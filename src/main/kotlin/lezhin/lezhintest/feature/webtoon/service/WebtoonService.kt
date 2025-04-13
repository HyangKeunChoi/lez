package lezhin.lezhintest.feature.webtoon.service

import lezhin.lezhintest.domain.Payment
import lezhin.lezhintest.feature.webtoon.controller.dto.WebtoonHistoryResponse
import lezhin.lezhintest.feature.webtoon.controller.dto.WebtoonInfoResponse
import lezhin.lezhintest.infrastructure.db.repository.event.IEventRepository
import lezhin.lezhintest.infrastructure.db.repository.payment.IPaymentRepository
import lezhin.lezhintest.infrastructure.db.repository.webtoon.IWebtoonRepository
import lezhin.lezhintest.infrastructure.db.repository.webtoonHistory.IWebtoonHistoryRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.core.ZSetOperations
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class WebtoonService(
    val webtoonRepository: IWebtoonRepository,
    val webtoonHistoryRepository: IWebtoonHistoryRepository,
    val eventRepository: IEventRepository,
    val paymentRepository: IPaymentRepository,
    private val redisTemplate: StringRedisTemplate,
) {
    fun getHistories(
        webtoonId: Long,
        pageable: Pageable
    ): Slice<WebtoonHistoryResponse>? {
        return webtoonHistoryRepository.findAllByWebtoonId(
            webtoonId = webtoonId,
            pageable = pageable,
        ).map {
            WebtoonHistoryResponse.from(it)
        }
    }

    private fun getWebtoonInfo(popularWebtoonIds: Set<ZSetOperations.TypedTuple<String>>): List<WebtoonInfoResponse> {
        val rankedWebtoonIds = popularWebtoonIds.sortedByDescending { it.score }
        val ids = rankedWebtoonIds.mapNotNull { it.value?.toLong() }
        val webtoons = webtoonRepository.findAllByIdIn(ids).associateBy { it.id }

        return rankedWebtoonIds.mapIndexedNotNull { index, typedTuple ->
            val id = typedTuple.value?.toLong()
            val rank = index + 1
            id?.let {
                webtoons[it]?.let { webtoon ->
                    WebtoonInfoResponse.from(rank, webtoon)
                }
            }
        }
    }

    fun getPopular(): List<WebtoonInfoResponse> {
        val popularWebtoonIds = redisTemplate.opsForZSet()
            .reverseRangeWithScores(POPULAR_FAVORITE_CACHE_KEY_PREFIX, POPULAR_START_INDEX, POPULAR_END_INDEX)
        return popularWebtoonIds?.let { getWebtoonInfo(it) } ?: emptyList()
    }

    @Transactional
    fun purchase(
        webtoonId: Long,
    ) {
        // 진행중인 이벤트를 전부 가져와서 이벤트 진행중인 것들만 필터링
        val ongoingEvents = eventRepository.findAll().filter { it.isOngoing }
        val eventIds = ongoingEvents.map { it.id }

        // 이벤트 대상이면 무료
        val isTargetEvent = eventRepository.existsEventsByWebtoonId(
            webtoonId = webtoonId,
            eventIds = eventIds
        )

        // 아니면 유료
        paymentComplete(webtoonId, isTargetEvent)
    }

    private fun paymentComplete(
        webtoonId: Long,
        targetEvent: Boolean
    ) {
        paymentRepository.save(
            Payment(
                webtoonId = webtoonId,
                paymentType = if (targetEvent) Payment.PaymentType.FREE else Payment.PaymentType.PAID,
            )
        )
    }

    companion object {
        const val POPULAR_FAVORITE_CACHE_KEY_PREFIX = "popular:cache"
        const val POPULAR_START_INDEX = 0L
        const val POPULAR_END_INDEX = 9L
    }
}
package lezhin.lezhintest.feature.webtoon.service

import lezhin.lezhintest.feature.webtoon.controller.dto.WebtoonHistoryResponse
import lezhin.lezhintest.infrastructure.db.repository.event.IEventRepository
import lezhin.lezhintest.infrastructure.db.repository.payment.IPaymentRepository
import lezhin.lezhintest.infrastructure.db.repository.webtoon.IWebtoonRepository
import lezhin.lezhintest.infrastructure.db.repository.webtoonHistory.IWebtoonHistoryRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class WebtoonService(
    val webtoonRepository: IWebtoonRepository,
    val webtoonHistoryRepository: IWebtoonHistoryRepository,
    val eventRepository: IEventRepository,
    val paymentRepository: IPaymentRepository,
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

}
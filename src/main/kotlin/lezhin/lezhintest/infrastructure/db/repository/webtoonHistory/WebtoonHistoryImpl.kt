package lezhin.lezhintest.infrastructure.db.repository.webtoonHistory

import lezhin.lezhintest.domain.WebtoonHistory
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.stereotype.Repository

@Repository
class WebtoonHistoryImpl(
    private val webtoonHistoryJpaRepository: WebtoonHistoryJpaRepository,
): IWebtoonHistoryRepository {
    override fun findAllByWebtoonId(
        webtoonId: Long,
        pageable: Pageable
    ): Slice<WebtoonHistory> {
        return webtoonHistoryJpaRepository.findAllByWebtoonId(
            webtoonId = webtoonId,
            pageable = pageable
        ).map { it.toModel() }
    }
}
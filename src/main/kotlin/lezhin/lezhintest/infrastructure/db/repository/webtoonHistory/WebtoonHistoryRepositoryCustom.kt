package lezhin.lezhintest.infrastructure.db.repository.webtoonHistory

import lezhin.lezhintest.infrastructure.db.entity.WebtoonHistoryEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice

interface WebtoonHistoryRepositoryCustom {
    fun findAllByWebtoonId(
        webtoonId: Long,
        pageable: Pageable
    ): Slice<WebtoonHistoryEntity>
}
package lezhin.lezhintest.infrastructure.db.repository.webtoonHistory

import lezhin.lezhintest.domain.WebtoonHistory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice

interface IWebtoonHistoryRepository {
    fun findAllByWebtoonId(
        webtoonId: Long,
        pageable: Pageable
    ): Slice<WebtoonHistory>

    fun findIdsByWebtoonId(
        webtoonId: Long,
        pageable: Pageable,
    ): Page<Long>
}
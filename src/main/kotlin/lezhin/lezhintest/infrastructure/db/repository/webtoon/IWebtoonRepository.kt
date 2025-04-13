package lezhin.lezhintest.infrastructure.db.repository.webtoon

import lezhin.lezhintest.domain.Webtoon

interface IWebtoonRepository {
    fun findAllByIdIn(ids: List<Long>): List<Webtoon>
    fun deleteById(id: Long)
}
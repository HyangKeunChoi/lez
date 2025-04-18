package lezhin.lezhintest.infrastructure.db.repository.event

import lezhin.lezhintest.domain.Event

interface IEventRepository {
    fun findAll(): List<Event>
    fun existsEventsByWebtoonId(
        webtoonId: Long,
        eventIds: List<Long>
    ): Boolean
}
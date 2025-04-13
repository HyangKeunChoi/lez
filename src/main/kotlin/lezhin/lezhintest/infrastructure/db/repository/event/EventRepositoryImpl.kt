package lezhin.lezhintest.infrastructure.db.repository.event

import lezhin.lezhintest.domain.Event
import org.springframework.stereotype.Repository

@Repository
class EventRepositoryImpl(
    private val eventJpaRepository: EventJpaRepository,
) : IEventRepository {
    override fun findAll(): List<Event> {
        return eventJpaRepository.findAll().map { it.toModel() }
    }

    override fun existsEventsByWebtoonId(
        webtoonId: Long,
        eventIds: List<Long>
    ): Boolean {
        return eventJpaRepository.existsEventsByWebtoonId(
            webtoonId,
            eventIds
        )
    }
}
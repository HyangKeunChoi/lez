package lezhin.lezhintest.infrastructure.db.repository.event

import org.springframework.stereotype.Repository

@Repository
class EventRepositoryImpl(
    private val eventJpaRepository: EventJpaRepository,
): IEventRepository {
}
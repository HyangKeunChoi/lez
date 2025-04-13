package lezhin.lezhintest.infrastructure.db.repository.event

import lezhin.lezhintest.infrastructure.db.entity.EventEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EventJpaRepository: JpaRepository<EventEntity, Long> {
}
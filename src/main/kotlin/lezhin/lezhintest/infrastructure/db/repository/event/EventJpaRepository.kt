package lezhin.lezhintest.infrastructure.db.repository.event

import jdk.jfr.Event
import org.springframework.data.jpa.repository.JpaRepository

interface EventJpaRepository: JpaRepository<Event, Long> {
}
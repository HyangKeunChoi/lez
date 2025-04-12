package lezhin.lezhintest.infrastructure.db.entity

import jakarta.persistence.*
import lezhin.lezhintest.infrastructure.db.AbstractAuditEntity
import java.time.LocalDateTime

@Entity
@Table(name = "events")
class EventEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val startAt: LocalDateTime,
    val endAt: LocalDateTime,
): AbstractAuditEntity() {
}
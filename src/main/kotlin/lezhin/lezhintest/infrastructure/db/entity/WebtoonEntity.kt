package lezhin.lezhintest.infrastructure.db.entity

import jakarta.persistence.*
import lezhin.lezhintest.infrastructure.db.AbstractAuditEntity

@Entity
@Table(name = "webtoons")
class WebtoonEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
): AbstractAuditEntity() {
}
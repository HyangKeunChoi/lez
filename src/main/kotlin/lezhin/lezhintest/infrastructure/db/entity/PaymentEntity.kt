package lezhin.lezhintest.infrastructure.db.entity

import jakarta.persistence.*
import lezhin.lezhintest.infrastructure.db.AbstractAuditEntity

@Entity
@Table(name = "payments")
class PaymentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val webtoonId: Long,

): AbstractAuditEntity() {
}
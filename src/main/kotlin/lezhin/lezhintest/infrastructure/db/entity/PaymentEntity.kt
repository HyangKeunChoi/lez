package lezhin.lezhintest.infrastructure.db.entity

import jakarta.persistence.*
import lezhin.lezhintest.domain.Payment
import lezhin.lezhintest.infrastructure.db.AbstractAuditEntity

@Entity
@Table(name = "payments")
class PaymentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val webtoonId: Long,

    @Enumerated(EnumType.STRING)
    val paymentType: Payment.PaymentType,

) : AbstractAuditEntity() {
    fun toModel(): Payment = Payment(
        id = id,
        webtoonId = webtoonId,
        paymentType = paymentType,
        createdAt = createdAt,
        updatedAt = updatedAt,
    )

    companion object {

        @JvmStatic
        fun from(model: Payment): PaymentEntity = with(model) {
            PaymentEntity(
                id = id,
                webtoonId = webtoonId,
                paymentType = paymentType,
            )
        }
    }
}
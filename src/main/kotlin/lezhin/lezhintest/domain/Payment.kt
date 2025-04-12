package lezhin.lezhintest.domain

import java.time.LocalDateTime

data class Payment(
    val id: Long,
    val webtoonId: Long,
    val paymentType: PaymentType,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)

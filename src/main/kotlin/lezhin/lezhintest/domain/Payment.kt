package lezhin.lezhintest.domain

import java.time.LocalDateTime

data class Payment(
    val id: Long = 0,
    val webtoonId: Long,
    val paymentType: PaymentType,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
) {
    enum class PaymentType(val label: String) {
        PAID("유료"),
        FREE("무료");
    }
}

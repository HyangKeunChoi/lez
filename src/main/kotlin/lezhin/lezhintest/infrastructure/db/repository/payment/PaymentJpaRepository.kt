package lezhin.lezhintest.infrastructure.db.repository.payment

import lezhin.lezhintest.domain.Payment
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentJpaRepository: JpaRepository<Payment, Long> {
}
package lezhin.lezhintest.infrastructure.db.repository.payment

import lezhin.lezhintest.infrastructure.db.entity.PaymentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentJpaRepository: JpaRepository<PaymentEntity, Long> {
}
package lezhin.lezhintest.infrastructure.db.repository.payment

import org.springframework.stereotype.Repository

@Repository
class PaymentRepositoryImpl(
    private val paymentJpaRepository: PaymentJpaRepository,
): IPaymentRepository {
}
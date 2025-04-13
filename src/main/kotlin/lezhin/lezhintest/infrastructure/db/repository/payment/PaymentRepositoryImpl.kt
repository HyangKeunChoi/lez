package lezhin.lezhintest.infrastructure.db.repository.payment

import lezhin.lezhintest.domain.Payment
import lezhin.lezhintest.infrastructure.db.entity.PaymentEntity
import org.springframework.stereotype.Repository

@Repository
class PaymentRepositoryImpl(
    private val paymentJpaRepository: PaymentJpaRepository,
): IPaymentRepository {
    override fun save(payment: Payment): Payment {
        return paymentJpaRepository.save(PaymentEntity.from(payment)).toModel()
    }
}
package lezhin.lezhintest.infrastructure.db.repository.payment

import lezhin.lezhintest.domain.Payment

interface IPaymentRepository {
    fun save(payment: Payment): Payment
}
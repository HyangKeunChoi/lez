package lezhin.lezhintest.feature.webtoon.service

import lezhin.lezhintest.infrastructure.db.repository.event.IEventRepository
import lezhin.lezhintest.infrastructure.db.repository.payment.IPaymentRepository
import lezhin.lezhintest.infrastructure.db.repository.webtoon.IWebtoonRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class WebtoonService(
    val webtoonRepository: IWebtoonRepository,
    val eventRepository: IEventRepository,
    val paymentRepository: IPaymentRepository,
) {

}
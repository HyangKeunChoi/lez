package lezhin.lezhintest.domain

import java.time.LocalDateTime

class WebtoonHistory(
    val id: Long,
    val webtoonId: Long,
    val userId: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
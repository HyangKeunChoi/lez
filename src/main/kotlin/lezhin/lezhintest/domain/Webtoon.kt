package lezhin.lezhintest.domain

import java.time.LocalDateTime

class Webtoon(
    val id: Long,
    val name: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
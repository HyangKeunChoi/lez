package lezhin.lezhintest.domain

import java.time.LocalDateTime

data class EventWebtoon(
    val id: Long,
    val eventId: Long,
    val weboonId: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
package lezhin.lezhintest.domain

import java.time.LocalDateTime

data class Event(
    val id: Long,
    val name: String,
    val startAt: LocalDateTime,
    val endAt: LocalDateTime,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
    val isOngoing: Boolean
        get() {
            val now = LocalDateTime.now()
            return startAt.isBefore(now) && endAt.isBefore(now)
        }
}
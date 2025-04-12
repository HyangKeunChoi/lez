package lezhin.lezhintest.domain

import java.time.LocalDateTime

data class Event(
    val id: Long,
    val name: String,
    val startAt: LocalDateTime,
    val endAt: LocalDateTime,
) {
}
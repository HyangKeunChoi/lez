package lezhin.lezhintest.domain

import org.junit.jupiter.api.Assertions.assertFalse
import java.time.LocalDateTime
import kotlin.test.Test

internal class EventTest {

    @Test
    fun `isOngoing는 시작 시간이 현재시간보다 이전이면 false를 반환한다`() {
        val now = LocalDateTime.now()
        val event = Event(
            id = 1L,
            name = "Test",
            startAt = now.minusHours(1),
            endAt = now.minusMinutes(1),
            createdAt = now,
            updatedAt = now
        )
        assertFalse(event.isOngoing)
    }

    @Test
    fun `isOngoing는 현재 시간 기준 이후이면 false를 반환한다`() {
        val now = LocalDateTime.now()
        val event = Event(
            id = 1L,
            name = "Test",
            startAt = now.minusHours(1),
            endAt = now,
            createdAt = now,
            updatedAt = now
        )
        assertFalse(event.isOngoing)
    }
}
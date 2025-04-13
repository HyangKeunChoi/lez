package lezhin.lezhintest.feature.webtoon.controller.dto

import lezhin.lezhintest.domain.WebtoonHistory
import java.time.LocalDateTime

data class WebtoonHistoryResponse(
    val id: Long,
    val webtoonId: Long,
    val userId: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {

    companion object {
        @JvmStatic
        fun from(model: WebtoonHistory) = with(model) {
            WebtoonHistoryResponse(
                id = id,
                webtoonId = webtoonId,
                userId = userId,
                createdAt = createdAt,
                updatedAt = updatedAt,
            )
        }
    }
}

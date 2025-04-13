package lezhin.lezhintest.feature.webtoon.controller.dto

import lezhin.lezhintest.domain.Webtoon
import java.time.LocalDateTime

data class WebtoonInfoResponse(
    val rank: Int,
    val id: Long,
    val name: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
    companion object {
        @JvmStatic
        fun from(rank: Int, model: Webtoon) = with(model) {
            WebtoonInfoResponse(
                rank = rank,
                id = id,
                name = name,
                createdAt = createdAt,
                updatedAt = updatedAt,
            )
        }
    }
}

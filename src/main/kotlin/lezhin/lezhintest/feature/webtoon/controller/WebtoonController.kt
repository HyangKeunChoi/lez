package lezhin.lezhintest.feature.webtoon.controller

import jakarta.validation.constraints.NotNull
import lezhin.lezhintest.feature.webtoon.controller.dto.WebtoonHistoryResponse
import lezhin.lezhintest.feature.webtoon.service.WebtoonService
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Validated
@RestController
@RequestMapping("/api/v1/webtoon")
class WebtoonController(
    private val webtoonService: WebtoonService,
) {

    // slice
    @GetMapping("/{webtoonId}/history")
    fun getHistory(
        @PathVariable @NotNull webtoonId: Long,
        @PageableDefault(page = 0, size = 10, sort = ["id"], direction = Sort.Direction.DESC) pageable: Pageable
    ): ResponseEntity<Slice<WebtoonHistoryResponse>> {
        val result = webtoonService.getHistories(webtoonId, pageable)
        return ResponseEntity.ok(result)
    }

    // redis sorted set
    @GetMapping("/popular")
    fun getPopular() {

    }

    @PostMapping("/{webtoonId}/purchase")
    fun purchaseWebtoon(
        @PathVariable @NotNull webtoonId: Long
    ) {

    }

    // redis sorted set
    @GetMapping("/purchased/popular")
    fun getPurchasedPopular() {

    }

    @DeleteMapping("/{webtoonId}")
    fun deleteWebtoon() {

    }
}
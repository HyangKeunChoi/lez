package lezhin.lezhintest.feature.webtoon.controller

import jakarta.validation.constraints.NegativeOrZero
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import lezhin.lezhintest.feature.webtoon.controller.dto.WebtoonHistoryResponse
import lezhin.lezhintest.feature.webtoon.controller.dto.WebtoonInfoResponse
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
        @PathVariable
        @NotNull(message = "필수값입니다.")
        webtoonId: Long,

        @PageableDefault(page = 0, size = 10, sort = ["id"], direction = Sort.Direction.DESC) pageable: Pageable
    ): ResponseEntity<Slice<WebtoonHistoryResponse>> {
        val result = webtoonService.getHistories(webtoonId, pageable)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/popular")
    fun getPopular(): ResponseEntity<List<WebtoonInfoResponse>> {
        return ResponseEntity.ok().body(webtoonService.getPopular())
    }

    @PostMapping("/{webtoonId}/purchase")
    fun purchase(
        @PathVariable @NotNull webtoonId: Long
    ) {
        webtoonService.purchase(webtoonId)
    }

    @GetMapping("/purchased/popular")
    fun getPopularPurchased(): ResponseEntity<List<WebtoonInfoResponse>> {
        return ResponseEntity.ok().body(webtoonService.getPopularPurchased())
    }

    @DeleteMapping("/{webtoonId}")
    fun deleteWebtoon() {

    }
}
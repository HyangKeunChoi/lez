package lezhin.lezhintest.feature.webtoon.controller

import jakarta.validation.constraints.NotNull
import lezhin.lezhintest.feature.webtoon.service.WebtoonService
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
        @PathVariable @NotNull webtoonId: Long
    ) {

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
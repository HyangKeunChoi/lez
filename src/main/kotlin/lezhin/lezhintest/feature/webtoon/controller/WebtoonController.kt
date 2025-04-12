package lezhin.lezhintest.feature.webtoon.controller

import jakarta.validation.constraints.NotNull
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/webtoon")
class WebtoonController {


    @GetMapping("/{webtoonId}/history")
    fun getHistory(
        @PathVariable @NotNull webtoonId: Long
    ) {

    }

    @GetMapping("/popular")
    fun getPopular() {

    }

    @PostMapping("{webtoonId}/purchase")
    fun purchaseWebtoon(
        @PathVariable @NotNull webtoonId: Long
    ) {

    }

    @GetMapping("/purchased/popular")
    fun getPurchasedPopular() {

    }

    @DeleteMapping("{webtoonId}")
    fun deleteWebtoon() {

    }
}
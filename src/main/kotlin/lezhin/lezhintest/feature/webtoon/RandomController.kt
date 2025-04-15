package lezhin.lezhintest.feature.webtoon

import lezhin.lezhintest.auth.JwtTokenProvider
import lezhin.lezhintest.auth.TokenInfo
import lezhin.lezhintest.feature.webtoon.service.WebtoonService.Companion.POPULAR_FAVORITE_CACHE_KEY_PREFIX
import lezhin.lezhintest.feature.webtoon.service.WebtoonService.Companion.POPULAR_PURCHASED_CACHE_KEY_PREFIX
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/v1/random")
class RandomController(
    private val authenticationManagerBuilder: AuthenticationManagerBuilder,
    private val jwtTokenProvider: JwtTokenProvider,
    private val redisTemplate: StringRedisTemplate,
) {

    @PostMapping("/token")
    fun createToken(): TokenInfo {
        // 사용자가 없기 때문에 1, 1로 하드코딩
        val authenticationToken = UsernamePasswordAuthenticationToken("1", "1")
        val authentication = authenticationManagerBuilder.`object`.authenticate(authenticationToken)
        return jwtTokenProvider.createToken(authentication)
    }

    @GetMapping("/suffle")
    fun shuffle() {
        val ops = redisTemplate.opsForZSet()
        val random = Random()

        // 샘플 웹툰 ID와 구매 횟수 (스코어) 생성
        for (i in 1..20) { // 20개의 샘플 웹툰 데이터 생성 (조절 가능)
            val webtoonId = "webtoon:$i"
            val randomCount = random.nextInt(100) + 1 // 1 ~ 100 사이의 랜덤 구매 횟수
            ops.add(POPULAR_PURCHASED_CACHE_KEY_PREFIX, webtoonId, randomCount.toDouble())
            ops.add(POPULAR_FAVORITE_CACHE_KEY_PREFIX, webtoonId, randomCount.toDouble())
        }
    }
}
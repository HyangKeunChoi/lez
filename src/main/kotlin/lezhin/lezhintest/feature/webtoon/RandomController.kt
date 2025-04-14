package lezhin.lezhintest.feature.webtoon

import lezhin.lezhintest.auth.JwtTokenProvider
import lezhin.lezhintest.auth.TokenInfo
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/random")
class RandomController(
    private val authenticationManagerBuilder: AuthenticationManagerBuilder,
    private val jwtTokenProvider: JwtTokenProvider
) {

    @PostMapping("/token")
    fun createToken(): TokenInfo {
        // 사용자가 없기 때문에 1, 1로 하드코딩
        val authenticationToken = UsernamePasswordAuthenticationToken("1", "1")
        val authentication = authenticationManagerBuilder.`object`.authenticate(authenticationToken)
        return jwtTokenProvider.createToken(authentication)
    }
}
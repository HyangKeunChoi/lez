package lezhin.lezhintest.feature.controller

import lezhin.lezhintest.auth.JwtTokenProvider
import lezhin.lezhintest.feature.webtoon.controller.dto.WebtoonHistoryResponse
import lezhin.lezhintest.feature.webtoon.service.WebtoonService
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.BeforeEach
import org.mockito.BDDMockito.given
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.SliceImpl
import org.springframework.data.domain.Sort
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.time.LocalDateTime
import kotlin.test.Test

@SpringBootTest
@AutoConfigureMockMvc
internal class WebtoonControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var authenticationManagerBuilder: AuthenticationManagerBuilder

    @Autowired
    lateinit var jwtTokenProvider: JwtTokenProvider

    @MockBean
    lateinit var webtoonService: WebtoonService

    private lateinit var jwtToken: String

    @BeforeEach
    fun setUp() {
        // Spring Security 인증 및 JWT 토큰 생성
        val authenticationToken = UsernamePasswordAuthenticationToken("1", "1")
        val authentication = authenticationManagerBuilder.`object`.authenticate(authenticationToken)
        SecurityContextHolder.getContext().authentication = authentication
        jwtToken = jwtTokenProvider.createToken(authentication).accessToken
    }

    @Test
    fun `웹툰의 history 조회 테스트`() {
        // Given
        val webtoonId = 123L
        val pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id"))
        val now = LocalDateTime.now()
        val historyList = listOf(
            WebtoonHistoryResponse(1L, 1L, 1, now, now),
            WebtoonHistoryResponse(2L, 2L, 2, now, now)
        )
        val slice = SliceImpl(historyList, pageable, true)
        given(webtoonService.getHistories(webtoonId, pageable)).willReturn(slice)

        // When & Then
        mockMvc.get("/api/v1/webtoon/{webtoonId}/history", webtoonId) {
            header("Authorization", "Bearer $jwtToken")
            param("page", "0")
            param("size", "10")
            param("sort", "id,DESC")
        }.andDo { println() }
            .andExpect {
                MockMvcResultMatchers.status().isOk
                content {
                    jsonPath("$.content[0].id", equalTo(1))
                    jsonPath("$.content[0].webtoonId", equalTo(1))
                }
            }

        verify(webtoonService).getHistories(webtoonId, pageable)
    }
}
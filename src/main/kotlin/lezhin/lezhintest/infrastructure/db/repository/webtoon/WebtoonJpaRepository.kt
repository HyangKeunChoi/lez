package lezhin.lezhintest.infrastructure.db.repository.webtoon

import lezhin.lezhintest.domain.Webtoon
import org.springframework.data.jpa.repository.JpaRepository

interface WebtoonJpaRepository: JpaRepository<Webtoon, Long> {
}
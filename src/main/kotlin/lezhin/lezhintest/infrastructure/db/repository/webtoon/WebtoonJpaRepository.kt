package lezhin.lezhintest.infrastructure.db.repository.webtoon

import lezhin.lezhintest.infrastructure.db.entity.WebtoonEntity
import org.springframework.data.jpa.repository.JpaRepository

interface WebtoonJpaRepository: JpaRepository<WebtoonEntity, Long> {
}
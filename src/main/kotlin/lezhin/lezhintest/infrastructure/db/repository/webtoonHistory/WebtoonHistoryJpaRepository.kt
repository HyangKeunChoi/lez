package lezhin.lezhintest.infrastructure.db.repository.webtoonHistory

import lezhin.lezhintest.infrastructure.db.entity.WebtoonHistoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface WebtoonHistoryJpaRepository: JpaRepository<WebtoonHistoryEntity, Long>, WebtoonHistoryRepositoryCustom {
}
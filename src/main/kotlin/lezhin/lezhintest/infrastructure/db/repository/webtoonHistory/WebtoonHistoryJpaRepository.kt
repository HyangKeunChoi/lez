package lezhin.lezhintest.infrastructure.db.repository.webtoonHistory

import lezhin.lezhintest.infrastructure.db.entity.WebtoonHistoryEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface WebtoonHistoryJpaRepository : JpaRepository<WebtoonHistoryEntity, Long>, WebtoonHistoryRepositoryCustom {

    @Query("SELECT h.id FROM WebtoonHistoryEntity h WHERE h.webtoonId = :webtoonId")
    fun findIdsByWebtoonId(@Param("webtoonId") webtoonId: Long, pageable: Pageable): Page<Long>
}
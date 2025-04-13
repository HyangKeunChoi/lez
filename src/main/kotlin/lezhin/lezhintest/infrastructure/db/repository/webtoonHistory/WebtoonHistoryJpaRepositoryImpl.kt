package lezhin.lezhintest.infrastructure.db.repository.webtoonHistory

import com.querydsl.jpa.impl.JPAQueryFactory
import lezhin.lezhintest.domain.WebtoonHistory
import lezhin.lezhintest.infrastructure.db.entity.QWebtoonHistoryEntity.webtoonHistoryEntity
import lezhin.lezhintest.infrastructure.db.entity.WebtoonHistoryEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.data.domain.SliceImpl
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

@Repository
class WebtoonHistoryJpaRepositoryImpl(
    val jpaQueryFactory: JPAQueryFactory
): QuerydslRepositorySupport(WebtoonHistoryEntity::class.java), WebtoonHistoryRepositoryCustom {
    override fun findAllByWebtoonId(
        webtoonId: Long,
        pageable: Pageable
    ): Slice<WebtoonHistoryEntity> {
        val result = jpaQueryFactory.selectFrom(webtoonHistoryEntity)
            .where(
                webtoonHistoryEntity.webtoonId.eq(webtoonId),
            )
            .limit(pageable.pageSize.toLong() + 1)
            .fetch()
            .toMutableList()

        var hasNext = false
        if (result.size > pageable.pageSize) {
            result.removeAt(pageable.pageSize)
            hasNext = true
        }

        return SliceImpl(result, pageable, hasNext)
    }
}
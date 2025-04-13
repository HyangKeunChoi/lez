package lezhin.lezhintest.infrastructure.db.repository.event

import com.querydsl.jpa.impl.JPAQueryFactory
import lezhin.lezhintest.infrastructure.db.entity.EventEntity
import lezhin.lezhintest.infrastructure.db.entity.QEventEntity.eventEntity
import lezhin.lezhintest.infrastructure.db.entity.QEventWebtoonEntity.eventWebtoonEntity
import lezhin.lezhintest.infrastructure.db.entity.QWebtoonEntity.webtoonEntity
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

@Repository
class EventJpaRepositoryImpl(
    val jpaQueryFactory: JPAQueryFactory,
) : QuerydslRepositorySupport(EventEntity::class.java), EventRepositoryCustom {
    override fun existsEventsByWebtoonId(
        webtoonId: Long,
        eventIds: List<Long>
    ): Boolean {
        return jpaQueryFactory.selectOne()
            .from(eventEntity)
            .innerJoin(eventWebtoonEntity)
                .on(eventWebtoonEntity.event.eq(eventEntity).and(eventEntity.id.`in`(eventIds)))
            .innerJoin(webtoonEntity)
                .on(webtoonEntity.eq(eventWebtoonEntity.webtoon).and(webtoonEntity.id.eq(webtoonId)))
            .fetchFirst() != null
    }
}
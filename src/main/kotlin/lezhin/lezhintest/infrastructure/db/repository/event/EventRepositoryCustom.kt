package lezhin.lezhintest.infrastructure.db.repository.event

interface EventRepositoryCustom {
    fun existsEventsByWebtoonId(
        webtoonId: Long,
        eventIds: List<Long>
    ): Boolean
}
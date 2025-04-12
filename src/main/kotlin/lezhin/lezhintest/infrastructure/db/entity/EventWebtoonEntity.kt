package lezhin.lezhintest.infrastructure.db.entity

import jakarta.persistence.*
import lezhin.lezhintest.infrastructure.db.AbstractAuditEntity

@Entity
@Table(name = "event_webtoons")
class EventWebtoonEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    val event: EventEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "webtoon_id")
    val webtoon: WebtoonEntity,

): AbstractAuditEntity() {
}
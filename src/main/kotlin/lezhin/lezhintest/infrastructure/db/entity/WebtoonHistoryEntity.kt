package lezhin.lezhintest.infrastructure.db.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import lezhin.lezhintest.infrastructure.db.AbstractAuditEntity

@Entity
@Table(name = "webtoon_histories")
class WebtoonHistoryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val userId: Long,
): AbstractAuditEntity() {
}
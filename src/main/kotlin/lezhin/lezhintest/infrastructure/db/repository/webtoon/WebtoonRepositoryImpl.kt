package lezhin.lezhintest.infrastructure.db.repository.webtoon

import lezhin.lezhintest.domain.Webtoon
import org.springframework.stereotype.Repository

@Repository
class WebtoonRepositoryImpl(
    private val webtoonJpaRepository: WebtoonJpaRepository,
) : IWebtoonRepository {
    override fun findAllByIdIn(ids: List<Long>): List<Webtoon> {
        return webtoonJpaRepository.findAllByIdIn(ids).map { it.toModel() }
    }

    override fun deleteById(id: Long) {
        return webtoonJpaRepository.deleteById(id)
    }
}
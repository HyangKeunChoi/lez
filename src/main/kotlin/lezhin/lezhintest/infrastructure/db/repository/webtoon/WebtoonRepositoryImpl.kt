package lezhin.lezhintest.infrastructure.db.repository.webtoon

import org.springframework.stereotype.Repository

@Repository
class WebtoonRepositoryImpl(
    private val webtoonJpaRepository: WebtoonJpaRepository,
): IWebtoonRepository {
}
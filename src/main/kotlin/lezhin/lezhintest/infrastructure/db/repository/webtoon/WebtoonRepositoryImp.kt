package lezhin.lezhintest.infrastructure.db.repository.webtoon

import org.springframework.stereotype.Repository

@Repository
class WebtoonRepositoryImp(
    private val webtoonJpaRepository: WebtoonJpaRepository,
): IWebtoonRepository {
}
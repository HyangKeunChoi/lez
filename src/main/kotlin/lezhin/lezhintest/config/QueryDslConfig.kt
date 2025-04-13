package lezhin.lezhintest.config

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.function.Supplier

@Configuration
class QueryDslConfig(
    @PersistenceContext private val em: EntityManager
) {

    val jpaQueryFactory: JPAQueryFactory
        @Bean
        get() {
            val supplier = Supplier<EntityManager> { em }
            return JPAQueryFactory(supplier)
        }
}
package io.spring.ch10_graphql.repository

import io.spring.ch10_graphql.domain.Review
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ReviewRepository : ReactiveCrudRepository<Review, Int> {
}
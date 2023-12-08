package io.spring.ch08_webflux_functional.repository

import io.spring.ch08_webflux_functional.model.Course
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface CourseRepository : ReactiveMongoRepository<Course, String> {
    fun findAllByCategory(category: String): Flux<Course>
}

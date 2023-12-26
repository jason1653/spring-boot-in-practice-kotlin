package io.spring.ch10_graphql.repository

import io.spring.ch10_graphql.domain.Course
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CourseRepository : ReactiveCrudRepository<Course, Int> {
}
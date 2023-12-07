package io.spring.ch07_api.repository

import io.spring.ch07_api.model.Course
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository : CrudRepository<Course, Long> {
    fun findAllByCategory(category: String): List<Course>
}

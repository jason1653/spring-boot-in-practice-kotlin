package io.spring.ch03_database_namedquery.repository

import io.spring.ch03_database_namedquery.model.Course
import org.springframework.data.repository.CrudRepository
import java.util.*

interface CourseRepository : CrudRepository<Course, Long> {
    fun findAllByCategoryAndRating(category: String, rating: Int): List<Course>


}

package io.spring.ch03_crud_repository.repository

import io.spring.ch03_crud_repository.model.Course
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository : CrudRepository<Course, Long> {
    fun findAllByCategory(category: String): List<Course>
    fun findAllByCategoryOrderByName(category: String): List<Course>
    fun existsByName(name: String): Boolean
    fun countByCategory(category: String): Long
    fun findByNameOrCategory(name: String, category: String): List<Course>
    fun findByNameStartsWith(name: String): List<Course>
    fun streamAllByCategory(category: String): List<Course>

}
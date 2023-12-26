package io.spring.ch09_jar.repository

import io.spring.ch09_jar.model.Course
import org.springframework.data.repository.CrudRepository

interface CourseRepository : CrudRepository<Course, Long> {
}
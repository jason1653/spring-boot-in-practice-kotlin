package io.spring.ch03_database_criteria.repository

import io.spring.ch03_database_criteria.model.Course
import org.springframework.data.repository.CrudRepository

interface CourseRepository : CrudRepository<Course, Long>

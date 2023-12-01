package io.spring.ch03_crud_repository.repository

import io.spring.ch03_crud_repository.model.Course
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository : CrudRepository<Course, Long>
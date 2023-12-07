package io.spring.ch05_spring_security_login_custom.repository

import io.spring.ch05_spring_security_login_custom.model.Course
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface CourseRepository : CrudRepository<Course, Long>

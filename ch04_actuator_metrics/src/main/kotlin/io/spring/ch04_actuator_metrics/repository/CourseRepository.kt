package io.spring.ch04_actuator_metrics.repository

import io.spring.ch04_actuator_metrics.model.Course
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface CourseRepository : CrudRepository<Course, Long>

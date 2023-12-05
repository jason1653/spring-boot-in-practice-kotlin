package io.spring.ch04_actuator_info_endpoint.service

import io.spring.ch04_actuator_info_endpoint.model.Course
import io.spring.ch04_actuator_info_endpoint.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(
    private val courseRepository: CourseRepository
) {
    fun getAailableCourses(): MutableIterable<Course> {
        return courseRepository.findAll()
    }
}
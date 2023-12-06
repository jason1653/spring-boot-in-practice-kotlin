package io.spring.ch04_actuator_metrics_custom.service

import io.spring.ch04_actuator_metrics_custom.model.Course

interface CourseServiceImpl {
    fun createCourse(course: Course): Course

    fun findCourseById(id: Long): Course?

    fun findAllCourses(): Iterable<Course>

    fun updateCourse(course: Course): Course

    fun deleteCourseById(id: Long)

    fun count(): Long
}
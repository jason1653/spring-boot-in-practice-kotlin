package io.spring.ch07_api.service

import io.spring.ch07_api.model.Course
import java.util.*

interface CourseService {
    fun createCourse(course: Course): Course

    fun getCourseById(id: Long): Course

    fun getCoursesByCategory(category: String): List<Course>

    fun getCourses(): MutableIterable<Course>

    fun updateCourse(courseId: Long, course: Course)

    fun deleteCourseById(id: Long)

    fun deleteCourses()
}
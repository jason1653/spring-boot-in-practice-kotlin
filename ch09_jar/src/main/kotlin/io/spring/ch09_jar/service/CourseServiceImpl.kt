package io.spring.ch09_jar.service

import io.spring.ch09_jar.model.Course
import java.util.*


interface CourseServiceImpl {
    fun createCourse(course: Course?): Course?

    fun findCourseById(courseId: Long?): Optional<Course?>?

    fun findAllCourses(): Iterable<Course?>?

    fun updateCourse(course: Course?): Course?

    fun deleteCourseById(courseId: Long?)
}
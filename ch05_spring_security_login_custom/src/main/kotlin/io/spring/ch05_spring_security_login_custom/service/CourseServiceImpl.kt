package io.spring.ch05_spring_security_login_custom.service

import io.spring.ch05_spring_security_login_custom.model.Course
import java.util.*


interface CourseServiceImpl {
    fun createCourse(course: Course?): Course?

    fun findCourseById(courseId: Long?): Optional<Course?>?

    fun findAllCourses(): Iterable<Course?>?

    fun updateCourse(course: Course?): Course?

    fun deleteCourseById(courseId: Long?)
}
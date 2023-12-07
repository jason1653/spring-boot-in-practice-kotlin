package io.spring.ch05_spring_security_login_custom.service

import io.spring.ch05_spring_security_login_custom.model.Course
import io.spring.ch05_spring_security_login_custom.repository.CourseRepository
import org.springframework.stereotype.Service
import java.util.*


@Service
class CourseService(
    private val courseRepository: CourseRepository,
) {
    fun createCourse(course: Course?): Course {
        return courseRepository.save(course!!)
    }

    fun findCourseById(courseId: Long?): Optional<Course> {
        return courseRepository.findById(courseId!!)
    }

    fun findAllCourses(): Iterable<Course> {
        return courseRepository.findAll()
    }

    fun updateCourse(course: Course?): Course {
        return courseRepository.save(course!!)
    }

    fun deleteCourseById(courseId: Long?) {
        courseRepository.deleteById(courseId!!)
    }
}
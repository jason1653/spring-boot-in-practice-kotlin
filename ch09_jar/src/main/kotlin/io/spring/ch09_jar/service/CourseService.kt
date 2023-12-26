package io.spring.ch09_jar.service

import io.spring.ch09_jar.model.Course
import io.spring.ch09_jar.repository.CourseRepository
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
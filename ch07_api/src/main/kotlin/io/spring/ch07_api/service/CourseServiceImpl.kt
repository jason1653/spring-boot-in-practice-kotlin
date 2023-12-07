package io.spring.ch07_api.service

import io.spring.ch07_api.exception.CourseNotFoundException
import io.spring.ch07_api.model.Course
import io.spring.ch07_api.repository.CourseRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseServiceImpl(
    private val courseRepository: CourseRepository
) : CourseService {
    override fun createCourse(course: Course): Course {
        return courseRepository.save(course)
    }

    override fun getCourseById(id: Long): Course {
        return courseRepository.findById(id).orElseThrow({ CourseNotFoundException("데이터가 없습니다") })
    }

    override fun getCoursesByCategory(category: String): List<Course> {
        return courseRepository.findAllByCategory(category)
    }

    override fun getCourses(): MutableIterable<Course> {
        return courseRepository.findAll()
    }

    override fun updateCourse(courseId: Long, course: Course) {
        courseRepository.findById(courseId).ifPresent {
            it.name = course.name
            it.category = course.category
            it.rating = course.rating
            it.description = course.description
            courseRepository.save(it)
        }
    }

    override fun deleteCourseById(id: Long) {
        courseRepository.findById(id).orElseThrow { CourseNotFoundException("데이터가 없습니다") }
        courseRepository.deleteById(id)
    }

    override fun deleteCourses() {
        courseRepository.deleteAll()
    }
}
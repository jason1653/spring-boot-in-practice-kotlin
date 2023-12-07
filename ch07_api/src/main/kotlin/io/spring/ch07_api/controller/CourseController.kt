package io.spring.ch07_api.controller

import io.spring.ch07_api.model.Course
import io.spring.ch07_api.service.CourseService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/courses/")
class CourseController @Autowired constructor(private val courseService: CourseService) {

    @get:GetMapping
    val allCourses: Iterable<Course>
        get() = courseService.getCourses()

    @GetMapping("{id}")
    fun getCourseById(@PathVariable("id") courseId: Long): Course {
        return courseService.getCourseById(courseId)
    }

    @GetMapping("category/{name}")
    fun getCourseByCategory(@PathVariable("name") category: String?): Iterable<Course> {
        return courseService.getCoursesByCategory(category!!)
    }

    @PostMapping
    fun createCourse(@RequestBody course: Course?): Course {
        return courseService.createCourse(course!!)
    }

    @PutMapping("{id}")
    fun updateCourse(@PathVariable("id") courseId: Long, @Valid @RequestBody course: Course) {
        courseService.updateCourse(courseId, course!!)
    }

    @DeleteMapping("{id}")
    fun deleteCourseById(@PathVariable("id") courseId: Long) {
        courseService.deleteCourseById(courseId)
    }

    @DeleteMapping
    fun deleteCourses() {
        courseService.deleteCourses()
    }
}

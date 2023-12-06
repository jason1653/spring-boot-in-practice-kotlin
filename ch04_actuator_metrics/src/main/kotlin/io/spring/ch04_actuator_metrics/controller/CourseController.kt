package io.spring.ch04_actuator_metrics.controller

import io.micrometer.core.instrument.Counter
import io.spring.ch04_actuator_metrics.model.Course
import io.spring.ch04_actuator_metrics.repository.CourseRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/courses")
class CourseController(
    private val courseRepository: CourseRepository,
    private val createCourseCounter: Counter
) {
    @PostMapping
    fun createCourse(@RequestBody course: Course) {
        try {
            createCourseCounter.increment()
        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception("오류")
        }
    }
}

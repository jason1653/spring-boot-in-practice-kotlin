package io.spring.ch04_actuator_metrics_custom.controller

import io.spring.ch04_actuator_metrics_custom.model.Course
import io.spring.ch04_actuator_metrics_custom.service.CourseService
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class CourseController(
    private val courseService: CourseService,
) {
    @GetMapping("/")
    fun index(): String {
        return "redirect:/index"
    }

    @GetMapping("/index")
    fun index(model: Model): String {
        val courseList = courseService.findAllCourses()
        model.addAttribute("courses", courseList)
        return "index"
    }

    @GetMapping("/addcourse")
    fun showAddCourseForm(course: Course): String {
        return "add-course"
    }

    @PostMapping("/addcourse")
    fun addCourse(course: @Valid Course?, result: BindingResult, model: Model): String? {
        if (result.hasErrors()) {
            return "add-course"
        }
        courseService.createCourse(course!!)
        model.addAttribute("courses", courseService.findAllCourses())
        return "redirect:/index"
    }
}

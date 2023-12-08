package io.spring.ch08_webflux.controller

import io.spring.ch08_webflux.model.Course
import io.spring.ch08_webflux.repository.CourseRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/courses")
class CourseController(
    private val courseRepository: CourseRepository,
) {
    @GetMapping
    fun getAllCourses(): Flux<Course> {
        return courseRepository.findAll()
    }

    @GetMapping("{id}")
    fun getCourseById(@PathVariable("id") id: String): Mono<ResponseEntity<Course>> {
        return courseRepository.findById(id)
            .map {
                ResponseEntity.ok(it)
            }
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    @GetMapping("/category/{name}")
    fun getCourseByCategory(@PathVariable("name") name: String): Flux<Course> {
        return courseRepository.findAllByCategory(name).doOnError {
            println("Error: $it.message")
        }
    }

    @PostMapping
    fun createCourse(@RequestBody course: Course): Mono<Course> {
        return courseRepository.save(course)
            .doOnSuccess {
                println("Saved $it")
            }
            .doOnError {
                println("Error: $it.message")
            }
    }

    @PutMapping("{id}")
    fun updateCourse(
        @PathVariable("id") id: String,
        @RequestBody course: Course,
    ): Mono<ResponseEntity<Course>> {
        return courseRepository.findById(id)
            .flatMap {
                it.name = course.name
                it.category = course.category
                it.rating = course.rating
                it.description = course.description
                courseRepository.save(it)
            }
            .map {
                ResponseEntity.ok(it)
            }
            .defaultIfEmpty(ResponseEntity.notFound().build())
            .doOnError {
                println("Error: $it.message")
            }
    }

    @DeleteMapping
    fun deleteCourses(): Mono<Void> {
        return courseRepository.deleteAll()
    }
}

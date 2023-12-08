package io.spring.ch08_webflux_functional.component

import io.spring.ch08_webflux_functional.model.Course
import io.spring.ch08_webflux_functional.repository.CourseRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class CourseHandler(
    private val courseRepository: CourseRepository,
) {
    fun findAllCourses(serverRequest: ServerRequest): Mono<ServerResponse> {
        val courses = courseRepository.findAll()
        return ServerResponse
            .ok()
            .contentType(APPLICATION_JSON)
            .body(courses, Course::class.java)
    }

    fun findCourseById(serverRequest: ServerRequest): Mono<ServerResponse> {
        val courseId = serverRequest.pathVariable("id")
        val courseMono = courseRepository.findById(courseId)
        return courseMono.flatMap {
            ServerResponse
                .ok()
                .contentType(APPLICATION_JSON)
                .bodyValue(it)
        }.switchIfEmpty(ServerResponse.notFound().build())
    }

    fun createCourse(serverRequest: ServerRequest): Mono<ServerResponse> {
        val courseMono = serverRequest.bodyToMono(Course::class.java)
        return courseMono.flatMap {
            ServerResponse
                .status(HttpStatus.CREATED)
                .contentType(APPLICATION_JSON)
                .body(courseRepository.save(it), Course::class.java)
        }
    }

    fun updateCourse(serverRequest: ServerRequest): Mono<ServerResponse> {
        val courseId = serverRequest.pathVariable("id")

        val existingCourseMono = courseRepository.findById(courseId)
        val newCourseMono = serverRequest.bodyToMono(Course::class.java)
        return newCourseMono
            .zipWith(existingCourseMono) { newCourse, existingCourse ->
                existingCourse.copy(
                    name = newCourse.name,
                    category = newCourse.category,
                    rating = newCourse.rating,
                    description = newCourse.description,
                )
            }
            .flatMap {
                ServerResponse
                    .ok()
                    .contentType(APPLICATION_JSON)
                    .bodyValue(it)
            }
    }

    fun deleteCourse(serverRequest: ServerRequest): Mono<ServerResponse> {
        val courseId = serverRequest.pathVariable("id")
        return courseRepository.findById(courseId)
            .flatMap {
                ServerResponse.ok().build(courseRepository.deleteById(courseId))
            }
            .switchIfEmpty(ServerResponse.notFound().build())
    }

    fun deleteAllCourses(serverRequest: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().build(courseRepository.deleteAll())
    }
}

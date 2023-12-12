package io.spring.ch08_webclient.api

import io.spring.ch08_webclient.model.Course
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class WebClientApi() {
    private val BASE_URL = "http://localhost:8080/courses"
    private var webClient: WebClient? = null
    init {
        webClient = WebClient.builder().baseUrl(BASE_URL).build()
    }

    fun postNewCourse(course: Course): Mono<ResponseEntity<Course>> {
        println("postNewCourse")
        return webClient!!
            .post()
            .body(Mono.just(course), Course::class.java)
            .retrieve()
            .toEntity(Course::class.java)
            .doOnSuccess {
                println("New course created: ${it.body}")
            }
    }

    fun updateCourse(id: String, name: String, category: String, rating: Int, description: String): Mono<Course> {
        return webClient!!
            .put()
            .uri("/$id")
            .body(Mono.just(Course(id, name, category, rating, description)), Course::class.java)
            .retrieve()
            .bodyToMono(Course::class.java)
            .doOnSuccess {
                println("Course updated: $it")
            }
    }

    fun getCourseById(id: String): Mono<Course> {
        return webClient!!
            .get()
            .uri("/$id")
            .retrieve()
            .bodyToMono(Course::class.java)
            .doOnSuccess {
                println("Course found: $it")
            }
            .doOnError {
                println("Course not found: ${it.message}")
            }
    }

    fun getAllCourses(): Flux<Course> {
        return webClient!!
            .get()
            .retrieve()
            .bodyToFlux(Course::class.java)
            .doOnNext {
                println("Course found: $it")
            }
            .doOnError {
                println("Course not found: ${it.message}")
            }
    }

    fun deleteCourse(id: String): Mono<Void> {
        return webClient!!
            .delete()
            .uri("/$id")
            .retrieve()
            .bodyToMono(Void::class.java)
            .doOnSuccess {
                println("Course deleted")
            }
            .doOnError {
                println("Course not found: ${it.message}")
            }
    }
}

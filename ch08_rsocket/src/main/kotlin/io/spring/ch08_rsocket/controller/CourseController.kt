package io.spring.ch08_rsocket.controller

import io.spring.ch08_rsocket.domain.Course
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration


@Controller
class CourseController {

    @MessageMapping("request-response")
    fun requestResponse(
        course: Course
    ): Mono<Course> {
        return Mono.just(Course("Your course name: ${course.courseName}"))
    }


    @MessageMapping("fire-and-forget")
    fun fireAndForget(
        course: Course
    ): Mono<Void> {
        println("Course name: ${course.courseName}")
        return Mono.empty()
    }


    @MessageMapping("request-stream")
    fun requestStream(
        course: Course
    ): Flux<Course> {
        return Flux.interval(Duration.ofSeconds(1))
            .map { index -> Course("Your course name: ${course.courseName} $index") }
            .log()
    }

    @MessageMapping("stream-stream")
    fun channel(
        settings: Flux<Integer>
    ): Flux<Course> {
        return settings
            .doOnNext { setting -> println("Setting: $setting") }
            .doOnCancel { println("Cancelled") }
            .switchMap { setting ->
                Flux.interval(Duration.ofSeconds(setting.toLong()))
                    .map { index ->
                        Course("Spring. Response #$index")
                    }
            }
            .log()
    }
}
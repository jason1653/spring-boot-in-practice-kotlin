package io.spring.ch08_webflux.config

import io.spring.ch08_webflux.model.Course
import io.spring.ch08_webflux.repository.CourseRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Flux

@Configuration
class CourseConfig {
    @Bean
    fun init(courseRepository: CourseRepository): CommandLineRunner {
        return CommandLineRunner { args ->
            val course1 = Course(
                name = "Mastering Spring Boot",
                category = "Spring",
                rating = 5,
                description = "Mastering Spring Boot 2.0",
            )

            val course2 = Course(
                name = "Mastering Python",
                category = "Python",
                rating = 5,
                description = "Mastering Python",
            )

            val course3 = Course(
                name = "Mastering Go",
                category = "Go",
                rating = 3,
                description = "Mastering Go",
            )

            Flux
                .just(course1, course2, course3)
                .flatMap { courseRepository.save(it) }
                .thenMany(courseRepository.findAll())
                .subscribe(
                    { println(it) },
                    { println("Error: $it.message") },
                    { println("Completed") },
                )
        }
    }
}

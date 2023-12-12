package io.spring.ch08_webclient.client

import io.spring.ch08_webclient.api.WebClientApi
import io.spring.ch08_webclient.model.Course
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApiClient {
    @Bean
    fun invokeCourseTrackerApi(webClientApi: WebClientApi): CommandLineRunner {
        return CommandLineRunner { args ->
            val course = Course(
                name = "Mastering Spring Boot",
                category = "Spring",
                rating = 5,
                description = "Mastering Spring Boot 2.0",
            )

            webClientApi.postNewCourse(course)
                .thenMany(webClientApi.getAllCourses())
                .subscribe()
        }
    }
}

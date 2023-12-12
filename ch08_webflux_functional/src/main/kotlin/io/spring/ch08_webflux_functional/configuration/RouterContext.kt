package io.spring.ch08_webflux_functional.configuration

import io.spring.ch08_webflux_functional.component.CourseHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class RouterContext {
    @Bean
    fun routes(courseHandler: CourseHandler): RouterFunction<ServerResponse> {
        return route()
            .GET("/courses", courseHandler::findAllCourses)
            .GET("/courses/{id}", courseHandler::findCourseById)
            .POST("/courses", courseHandler::createCourse)
            .PUT("/courses/{id}", courseHandler::updateCourse)
            .DELETE("/courses/{id}", courseHandler::deleteCourse)
            .DELETE("/courses", courseHandler::deleteAllCourses)
            .build()
    }
}

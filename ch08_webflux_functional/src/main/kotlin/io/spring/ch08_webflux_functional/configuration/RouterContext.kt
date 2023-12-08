package io.spring.ch08_webflux_functional.configuration

import io.spring.ch08_webflux_functional.component.CourseHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.coRouter
import org.springframework.web.reactive.function.server.router

@Configuration
class RouterContext {
    @Bean
    fun routes(courseHandler: CourseHandler): RouterFunction<ServerResponse> {

    }

}
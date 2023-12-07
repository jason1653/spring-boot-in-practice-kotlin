package io.spring.ch07_api.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class CourseTrackerGlobalExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(CourseNotFoundException::class)
    fun handleCourseNotFoundException(ex: CourseNotFoundException, request: WebRequest): ResponseEntity<Any>? {
        return super.handleExceptionInternal(
            ex,
            ex.message,
            HttpHeaders(),
            HttpStatus.NOT_FOUND,
            request,
        )
    }
}

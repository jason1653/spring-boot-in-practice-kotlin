package io.spring.ch07_api.exception


class CourseNotFoundException(message: String?) : RuntimeException(message) {
    companion object {
        private const val serialVersionUID = 5071646428281007896L
    }
}
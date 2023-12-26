package io.spring.ch08_rsocket.domain

import java.time.Instant
import java.util.*

class Course(val courseName: String) {
    val courseId: UUID = UUID.randomUUID()
    val created = Instant.now().epochSecond
}
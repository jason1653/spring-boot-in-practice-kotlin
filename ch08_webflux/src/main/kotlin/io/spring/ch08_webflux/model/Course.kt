package io.spring.ch08_webflux.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Course(
    @Id
    val id: String? = null,
    var name: String = "",
    var category: String = "",
    var rating: Int? = null,
    var description: String = "",
)

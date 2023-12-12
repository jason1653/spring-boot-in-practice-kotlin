package io.spring.ch08_webclient.model

data class Course(
    val id: String = "",
    val name: String = "",
    val category: String = "",
    val rating: Int = 0,
    val description: String = "",
)

package io.spring.ch03_database_many_to_many.dto

data class AuthorCourseDto(
    val id: Long,
    val authorName: String,
    val courseName: String,
    val description: String
) {

}

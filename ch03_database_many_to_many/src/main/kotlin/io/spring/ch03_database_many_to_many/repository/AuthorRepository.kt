package io.spring.ch03_database_many_to_many.repository

import io.spring.ch03_database_many_to_many.dto.AuthorCourseDto
import io.spring.ch03_database_many_to_many.model.Authors
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface AuthorRepository : CrudRepository<Authors, Long> {
    @Query("SELECT new io.spring.ch03_database_many_to_many.dto.AuthorCourseDto(c.Id, a.name, c.name, c.description) FROM AUTHORS a, COURSES c, AUTHORS_COURSE ac WHERE a.Id = ac.authors.Id AND c.Id=ac.course.Id and ac.authors.Id = ?1")
    fun getAuthorCourseInfo(authorId: Long): List<AuthorCourseDto>
}

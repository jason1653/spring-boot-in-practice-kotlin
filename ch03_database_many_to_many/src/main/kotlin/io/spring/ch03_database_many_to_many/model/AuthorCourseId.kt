package io.spring.ch03_database_many_to_many.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class AuthorCourseId(
    @Column(name = "author_id")
    var authorId: Long = 0,

    @Column(name = "course_id")
    var courseId: Long = 0
) : Serializable
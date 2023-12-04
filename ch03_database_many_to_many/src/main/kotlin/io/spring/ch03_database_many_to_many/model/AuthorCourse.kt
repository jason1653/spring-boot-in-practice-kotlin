package io.spring.ch03_database_many_to_many.model

import jakarta.persistence.*

@Entity(name = "AUTHORS_COURSE")
@Table(name = "AUTHORS_COURSES")
class AuthorCourse {

    @EmbeddedId
    var id: AuthorCourseId = AuthorCourseId()

    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    var authors: Authors? = null

    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    var course: Course? = null
}


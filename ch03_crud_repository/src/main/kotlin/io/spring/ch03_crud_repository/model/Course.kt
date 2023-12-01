package io.spring.ch03_crud_repository.model

import jakarta.persistence.*

@Entity
@Table(name = "COURSES")
data class Course(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "NAME")
    var name: String = "",

    @Column(name = "CATEGORY")
    var category: String = "",

    @Column(name = "RATING")
    var rating: Int = 0,

    @Column(name = "DESCRIPTION")
    var description: String = "",
)

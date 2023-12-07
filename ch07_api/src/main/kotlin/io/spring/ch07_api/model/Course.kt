package io.spring.ch07_api.model

import jakarta.persistence.*


@Entity
@Table(name = "COURSES")
class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long? = null

    @Column(name = "NAME")
    var name: String? = null

    @Column(name = "CATEGORY")
    var category: String? = null

    @Column(name = "RATING")
    var rating = 0

    @Column(name = "DESCRIPTION")
    var description: String? = null
}
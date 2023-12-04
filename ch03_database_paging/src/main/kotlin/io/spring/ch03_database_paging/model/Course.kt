package io.spring.ch03_database_paging.model

import jakarta.persistence.*

@Entity
@Table(name = "COURSES")
data class Course(
    @Column(name = "NAME")
    var name: String,

    @Column(name = "CATEGORY")
    val category: String,

    @Column(name = "RATING")
    val rating: Int,

    @Column(name = "DESCRIPTION")
    val description: String,
) {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
}

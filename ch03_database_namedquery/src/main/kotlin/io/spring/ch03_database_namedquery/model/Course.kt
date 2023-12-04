package io.spring.ch03_database_namedquery.model

import jakarta.persistence.*

@Entity
@Table(name = "COURSES")
@NamedQuery(name = "Course.findAllByCategoryAndRating", query = " SELECT c FROM Course c WHERE c.category = ?1 AND c.rating = ?2")
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

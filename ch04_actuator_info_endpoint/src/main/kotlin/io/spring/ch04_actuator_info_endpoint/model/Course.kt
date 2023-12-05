package io.spring.ch04_actuator_info_endpoint.model

import jakarta.persistence.*

@Entity
@Table(name = "COURSES")
class Course {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(name = "NAME")
    var name: String = ""

    @Column(name = "CATEGORY")
    val category: String = ""

    @Column(name = "RATING")
    val rating: Int = 0

    @Column(name = "DESCRIPTION")
    val description: String = ""
}

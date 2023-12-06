package io.spring.ch04_actuator_metrics.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "COURSES")
data class Course(
    @Id
    val id: Long,
    @Column(name = "NAME")
    var name: String? = null,
    @Column(name = "CATEGORY")
    var category: String? = null,
    @Column(name = "RATING")
    var rating: Int? = null,
    @Column(name = "DESCRIPTION")
    var description: String? = null,
)

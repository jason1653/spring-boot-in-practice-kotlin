package io.spring.ch03_database_many_to_many.model

import jakarta.persistence.*
import java.util.HashSet

@Entity(name = "COURSES")
@Table(name = "COURSES")
data class Course(
    val name: String = "",
    val category: String = "",
    val rating: Int = 0,
    val description: String = "",
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val Id: Long = 0

    @ManyToMany(mappedBy = "courses")
    private var authors: MutableSet<Authors?>? = HashSet()
}

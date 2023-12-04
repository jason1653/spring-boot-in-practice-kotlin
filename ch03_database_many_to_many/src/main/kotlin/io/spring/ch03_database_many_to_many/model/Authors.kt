package io.spring.ch03_database_many_to_many.model

import jakarta.persistence.*

@Entity(name = "AUTHORS")
@Table(name = "AUTHORS")
data class Authors(
    val name: String = "",
    val bio: String = "",
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val Id: Long = 0

    @ManyToMany
    @JoinTable(
        name = "authors_courses",
        joinColumns = [JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false, updatable = false)],
        inverseJoinColumns = [JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false, updatable = false)],
    )
    var courses: MutableSet<Course?>? = HashSet()
}

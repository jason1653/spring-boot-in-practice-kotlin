package io.spring.ch05_spring_security_login_custom.model

import jakarta.persistence.*
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty

@Entity
@Table(name = "COURSES")
class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long? = null

    @Column(name = "NAME")
    @NotEmpty(message = "Course name field can't be empty")
    var name: String? = null

    @Column(name = "CATEGORY")
    @NotEmpty(message = "Course category field can't be empty")
    var category: String? = null

    @Column(name = "RATING")
    @Min(value = 1)
    @Max(value = 5)
    var rating: Int = 0

    @Column(name = "DESCRIPTION")
    @NotEmpty(message = "Course description field can't be empty")
    var description: String? = null

    constructor()
    constructor(id: Long?, name: String?, category: String?, rating: Int, description: String?) {
        this.id = id
        this.name = name
        this.category = category
        this.rating = rating
        this.description = description
    }

    override fun toString(): String {
        return "Course{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", category='" + category + '\'' +
            ", rating=" + rating +
            ", description='" + description + '\'' +
            '}'
    }
}

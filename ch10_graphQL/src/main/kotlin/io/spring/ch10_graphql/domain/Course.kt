package io.spring.ch10_graphql.domain

import org.springframework.data.annotation.Id

class Course {
    @Id
    val id: Long? = null
    var name: String = ""
    var category: String = ""
    var description: String = ""
}
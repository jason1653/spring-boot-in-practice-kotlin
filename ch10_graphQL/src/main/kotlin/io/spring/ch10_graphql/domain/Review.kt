package io.spring.ch10_graphql.domain

import org.springframework.data.annotation.Id

class Review {
    @Id
    val id: Long? = null
    var courseId: Long = 0
    var reviewerName: String = ""
    var rating: Int = 0
    var comment: String = ""
}
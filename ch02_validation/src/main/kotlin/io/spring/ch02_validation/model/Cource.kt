package io.spring.ch02_validation.model

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

class Cource {
    @Min(value = 1, message = "A cource should have a minimum of 1 rating")
    @Max(value = 5, message = "A cource should have a maximum of 5 rating")
    var id: Int? = null
    var name: String? = null
    var category: String? = null

}
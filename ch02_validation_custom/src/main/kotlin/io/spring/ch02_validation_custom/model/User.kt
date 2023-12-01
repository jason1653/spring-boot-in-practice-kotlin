package io.spring.ch02_validation_custom.model

import io.spring.ch02_validation_custom.validators.Password

data class User(
    var userName: String,
    @Password
    var password: String
)
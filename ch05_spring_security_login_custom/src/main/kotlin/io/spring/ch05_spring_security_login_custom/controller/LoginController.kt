package io.spring.ch05_spring_security_login_custom.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LoginController {
    @GetMapping("/login")
    fun login(): String {
        return "login"
    }
}
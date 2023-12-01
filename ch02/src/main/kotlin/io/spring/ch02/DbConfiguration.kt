package io.spring.ch02

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment

@Configuration
@PropertySource("classpath:dbConfig.yml")
data class DbConfiguration(
    private val env: Environment,
) {
    override fun toString(): String {
        val user = env.getProperty("user")
        val password = env.getProperty("password")
        return "user: $user, password: $password"
    }
}

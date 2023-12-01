package io.spring.ch02_validation_custom

import io.spring.ch02_validation_custom.model.User
import jakarta.validation.Validation
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch02ValidationCustomApplication : CommandLineRunner {
    override fun run(vararg args: String?) {
        val user1 = User("sbip01", "sbip")

        val validator = Validation.buildDefaultValidatorFactory().validator
        var violations = validator.validate(user1)

        println("user1 violations")
        violations.forEach {
            println(it.message)
        }

        val user2 = User("sbip02", "Sbip01$4UDfg")
        violations = validator.validate(user2)
        println("user2 violations")

        violations.forEach {
            println(it.message)
        }

        val user3 = User("sbip03", "Sbip01$4UDfgggg")
        violations = validator.validate(user3)
        println("user3 violations")

        violations.forEach {
            println(it.message)
        }

        val user4 = User("sbip04", "Sbip04UDfgggg")
        violations = validator.validate(user4)
        println("user4 violations")

        violations.forEach {
            println(it.message)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<Ch02ValidationCustomApplication>(*args)
}

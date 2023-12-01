package io.spring.ch02_validation

import io.spring.ch02_validation.model.Cource
import jakarta.validation.Validation
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch02ValidationApplication : CommandLineRunner {
    val logger = LoggerFactory.getLogger(Ch02ValidationApplication::class.java)
    override fun run(vararg args: String?) {
        val cource = Cource()
        cource.id = 0
        cource.name = "Kotlin"

        val validator = Validation.buildDefaultValidatorFactory().validator

        val violations = validator.validate(cource)
        for (violation in violations) {
            logger.info(violation.message)
            println(violation.message)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<Ch02ValidationApplication>(*args)
}

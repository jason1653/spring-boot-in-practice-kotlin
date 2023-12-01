package io.spring.ch02_commandlinerunner

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Order(2)
@Component
class AnotherCommandLineRunnerComponent : CommandLineRunner {
    private val logger = LoggerFactory.getLogger(AnotherCommandLineRunnerComponent::class.java)
    override fun run(vararg args: String?) {
        println("AnotherCommandLineRunner CommandLineRunner has executed")
        logger.info("AnotherCommandLineRunner CommandLineRunner has executed")
    }
}

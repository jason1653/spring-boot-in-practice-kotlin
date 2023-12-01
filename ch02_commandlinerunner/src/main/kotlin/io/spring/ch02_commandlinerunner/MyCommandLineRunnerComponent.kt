package io.spring.ch02_commandlinerunner

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Order(1)
@Component
class MyCommandLineRunnerComponent : CommandLineRunner {
    val logger = LoggerFactory.getLogger(MyCommandLineRunnerComponent::class.java)
    override fun run(vararg args: String?) {
        println("MyCommandLineRunnerComponent CommandLineRunner has executed")
        logger.info("MyCommandLineRunnerComponent CommandLineRunner has executed")
    }
}
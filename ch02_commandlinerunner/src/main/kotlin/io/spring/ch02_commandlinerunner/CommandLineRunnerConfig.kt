package io.spring.ch02_commandlinerunner

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

//@Configuration
class CommandLineRunnerConfig {
    val logger = LoggerFactory.getLogger(CommandLineRunnerConfig::class.java)

    @Bean
    fun init(): CommandLineRunner {
        return CommandLineRunner { args ->
            logger.info("CommandLineRunner executed as a bean")
            for (i in 0 until args.size) {
                logger.info("args[$i] = ${args[i]}")
                println("args[$i] = ${args[i]}")
            }

            args
        }
    }
}

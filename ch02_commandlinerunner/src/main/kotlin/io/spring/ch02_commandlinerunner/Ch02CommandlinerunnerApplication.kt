package io.spring.ch02_commandlinerunner

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//@SpringBootApplication
//class Ch02CommandlinerunnerApplication : CommandLineRunner {
//    val logger = LoggerFactory.getLogger(Ch02CommandlinerunnerApplication::class.java)
//    override fun run(vararg args: String?) {
//        println("CourceTrackerApplication CommandLineRunner has executed")
//        logger.info("CourceTrackerApplication CommandLineRunner has executed")
//    }
//}

@SpringBootApplication
class Ch02CommandlinerunnerApplication {
    val logger = LoggerFactory.getLogger(Ch02CommandlinerunnerApplication::class.java)
}


fun main(args: Array<String>) {
    runApplication<Ch02CommandlinerunnerApplication>(*args)
}

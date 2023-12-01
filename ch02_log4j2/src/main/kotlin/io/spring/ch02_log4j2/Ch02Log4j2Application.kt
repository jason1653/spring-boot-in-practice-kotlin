package io.spring.ch02_log4j2

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch02Log4j2Application
inline fun <reified T> T.logger() = LoggerFactory.getLogger(T::class.java)

fun main(args: Array<String>) {
    val logger = LoggerFactory.getLogger(Ch02Log4j2Application::class.java)
    runApplication<Ch02Log4j2Application>(*args)

    logger.info("CourceTrackerApplication started succesfully with Log4j2")
}

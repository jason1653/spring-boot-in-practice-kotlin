package io.spring.ch04_custom_failure_analyzer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch04CustomFailureAnalyzerApplication

fun main(args: Array<String>) {
    runApplication<Ch04CustomFailureAnalyzerApplication>(*args)
}

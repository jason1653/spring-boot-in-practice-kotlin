package io.spring.ch03_database_custom

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch03DatabaseCustomApplication

fun main(args: Array<String>) {
    runApplication<Ch03DatabaseCustomApplication>(*args)
}

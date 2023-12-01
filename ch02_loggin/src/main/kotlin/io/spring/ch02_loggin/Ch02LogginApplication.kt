package io.spring.ch02_loggin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch02LogginApplication

fun main(args: Array<String>) {
    runApplication<Ch02LogginApplication>(*args)
}

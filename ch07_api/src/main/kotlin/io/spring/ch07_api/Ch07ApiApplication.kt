package io.spring.ch07_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch07ApiApplication

fun main(args: Array<String>) {
    runApplication<Ch07ApiApplication>(*args)
}

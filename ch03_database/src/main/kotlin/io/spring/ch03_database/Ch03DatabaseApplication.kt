package io.spring.ch03_database

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch03DatabaseApplication

fun main(args: Array<String>) {
    runApplication<Ch03DatabaseApplication>(*args)
}

package io.spring.ch09_jar

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch09JarApplication

fun main(args: Array<String>) {
    runApplication<Ch09JarApplication>(*args)
}

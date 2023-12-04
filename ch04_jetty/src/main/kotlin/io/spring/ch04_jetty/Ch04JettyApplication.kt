package io.spring.ch04_jetty

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch04JettyApplication

fun main(args: Array<String>) {
    runApplication<Ch04JettyApplication>(*args)
}

package io.spring.ch04_actuator_custom

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch04ActuatorCustomApplication

fun main(args: Array<String>) {
    runApplication<Ch04ActuatorCustomApplication>(*args)
}

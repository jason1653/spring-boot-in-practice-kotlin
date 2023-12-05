package io.spring.ch04_actuator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch04ActuatorApplication

fun main(args: Array<String>) {
    runApplication<Ch04ActuatorApplication>(*args)
}

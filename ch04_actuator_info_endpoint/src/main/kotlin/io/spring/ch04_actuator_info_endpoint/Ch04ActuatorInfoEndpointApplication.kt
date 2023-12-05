package io.spring.ch04_actuator_info_endpoint

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch04ActuatorInfoEndpointApplication

fun main(args: Array<String>) {
    runApplication<Ch04ActuatorInfoEndpointApplication>(*args)
}

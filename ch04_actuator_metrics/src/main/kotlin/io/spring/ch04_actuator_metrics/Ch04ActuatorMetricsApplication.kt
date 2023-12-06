package io.spring.ch04_actuator_metrics

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch04ActuatorMetricsApplication

fun main(args: Array<String>) {
    runApplication<Ch04ActuatorMetricsApplication>(*args)
}

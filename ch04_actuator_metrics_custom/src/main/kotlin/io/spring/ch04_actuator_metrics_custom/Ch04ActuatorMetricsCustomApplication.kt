package io.spring.ch04_actuator_metrics_custom

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch04ActuatorMetricsCustomApplication

fun main(args: Array<String>) {
    runApplication<Ch04ActuatorMetricsCustomApplication>(*args)
}

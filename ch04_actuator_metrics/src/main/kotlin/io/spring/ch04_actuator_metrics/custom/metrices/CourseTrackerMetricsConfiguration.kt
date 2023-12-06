package io.spring.ch04_actuator_metrics.custom.metrices

import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CourseTrackerMetricsConfiguration {
    @Bean
    fun createCourseCounter(meterRegistry: MeterRegistry?): Counter {
        return Counter.builder("api.courses.created.count")
            .description("Total number of courses created")
            .register(meterRegistry!!)
    }
}
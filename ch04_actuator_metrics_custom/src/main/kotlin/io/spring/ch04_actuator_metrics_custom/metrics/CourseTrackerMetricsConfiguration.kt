package io.spring.ch04_actuator_metrics_custom.metrics

import io.micrometer.core.instrument.*
import io.spring.ch04_actuator_metrics_custom.service.CourseService
import io.spring.ch04_actuator_metrics_custom.service.CourseServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CourseTrackerMetricsConfiguration {

    @Bean
    fun createCourseCount(meterRegistry: MeterRegistry): Counter {
        return Counter
            .builder("api.courses.created.count")
            .description("Total number of courses created")
            .register(meterRegistry)
    }

    @Bean
    fun createCoursesGauge(meterRegistry: MeterRegistry, conurServiceImpl: CourseServiceImpl): Gauge {
        return Gauge
            .builder("api.courses.created.gauge", conurServiceImpl::count)
            .description("Total number of courses created")
            .register(meterRegistry)
    }

    @Bean
    fun createCoursesTimer(meterRegistry: MeterRegistry): Timer {
        return Timer
            .builder("api.courses.created.timer")
            .description("Total number of courses created")
            .register(meterRegistry)
    }

    @Bean
    fun createCoursesDistributionSummary(meterRegistry: MeterRegistry): DistributionSummary {
        return DistributionSummary
            .builder("api.courses.created.distribution.summary")
            .description("Total number of courses created")
            .register(meterRegistry)
    }
}

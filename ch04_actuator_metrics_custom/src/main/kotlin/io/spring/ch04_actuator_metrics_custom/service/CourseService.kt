package io.spring.ch04_actuator_metrics_custom.service

import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.DistributionSummary
import io.micrometer.core.instrument.Timer
import io.spring.ch04_actuator_metrics_custom.model.Course
import io.spring.ch04_actuator_metrics_custom.repository.CourseRepository
import org.springframework.stereotype.Service
import java.util.concurrent.Callable

@Service
class CourseService(
    private val courseRepository: CourseRepository,
    private val createCourseCount: Counter,
    private val createCoursesTimer: Timer,
    private val distributionSummary: DistributionSummary,
) : CourseServiceImpl {
    override fun createCourse(course: Course): Course {
        createCourseCount.increment()
        distributionSummary.record(course.rating.toDouble())
        return createCoursesTimer.recordCallable(
            Callable<Course> {
                courseRepository.save(
                    course,
                )
            },
        )!!
    }

    override fun findCourseById(id: Long): Course? {
        TODO("Not yet implemented")
    }

    override fun findAllCourses(): Iterable<Course> {
        return courseRepository.findAll()
    }

    override fun updateCourse(course: Course): Course {
        TODO("Not yet implemented")
    }

    override fun deleteCourseById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        return courseRepository.count()
    }
}

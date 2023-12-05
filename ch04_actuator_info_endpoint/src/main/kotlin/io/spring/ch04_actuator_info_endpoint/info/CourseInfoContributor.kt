package io.spring.ch04_actuator_info_endpoint.info

import io.spring.ch04_actuator_info_endpoint.dto.CourseNameRating
import io.spring.ch04_actuator_info_endpoint.service.CourseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.info.Info
import org.springframework.boot.actuate.info.InfoContributor
import org.springframework.stereotype.Component

@Component
class CourseInfoContributor(
    @Autowired
    private val courseService: CourseService,
) : InfoContributor {
    override fun contribute(builder: Info.Builder?) {
        val courseNameRatingList: List<CourseNameRating> = courseService.getAailableCourses()
            .map { CourseNameRating(it.name, it.rating) }

        builder?.withDetail("courses", courseNameRatingList)
    }
}

package io.spring.ch03_database_query

import io.spring.ch03_database_query.model.Course
import io.spring.ch03_database_query.repository.CourseRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class Ch03DatabaseQueryApplicationTests(
    @Autowired
    private val courseRepository: CourseRepository,
) {

    @Test
    fun givenCoursesCreatedWhenLoadCoursesWithQueryThenExpectCorrectCourseDetails() {
        saveMockCourses()
        assertThat(courseRepository.findAllByCategory("Spring")).hasSize(3)
        assertThat(courseRepository.findAllByRating(3)).hasSize(2)
        assertThat(courseRepository.findAllByCategoryAndRatingGreaterThan("Spring", 3)).hasSize(2)
        courseRepository.updateCourseRatingByName(4, "Getting Started with Spring Cloud Kubernetes")
        assertThat(courseRepository.findAllByCategoryAndRatingGreaterThan("Spring", 3)).hasSize(3)
    }

    private fun saveMockCourses() {
        val rapidSpringBootCourse = Course(
            "Rapid Spring Boot Application Development",
            "Spring",
            4,
            "Spring Boot gives all the power of the Spring Framework without all of the complexity",
        )
        val springSecurityDslCourse =
            Course("Getting Started with Spring Security DSL", "Spring", 5, "Learn Spring Security DSL in easy steps")
        val springCloudKubernetesCourse = Course(
            "Getting Started with Spring Cloud Kubernetes",
            "Spring",
            3,
            "Master Spring Boot application deployment with Kubernetes",
        )
        val rapidPythonCourse =
            Course("Getting Started with Python", "Python", 5, "Learn Python concepts in easy steps")
        val gameDevelopmentWithPython =
            Course("Game Development with Python", "Python", 3, "Learn Python by developing 10 wonderful games")
        val javaScriptForAll =
            Course("JavaScript for All", "JavaScript", 4, "Learn basic JavaScript syntax that can apply to anywhere")
        val javaScriptCompleteGuide = Course(
            "JavaScript Complete Guide",
            "JavaScript",
            5,
            "Master JavaScript with Core Concepts and Web Development",
        )
        val courses: List<Course> = Arrays.asList(
            rapidSpringBootCourse,
            springSecurityDslCourse,
            springCloudKubernetesCourse,
            rapidPythonCourse,
            gameDevelopmentWithPython,
            javaScriptForAll,
            javaScriptCompleteGuide,
        )
        courseRepository.saveAll(courses)
    }
}

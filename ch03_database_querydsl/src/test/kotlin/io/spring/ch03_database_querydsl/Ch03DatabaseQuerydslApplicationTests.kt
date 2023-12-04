package io.spring.ch03_database_querydsl

import com.querydsl.jpa.impl.JPAQuery
import io.spring.ch03_database_querydsl.model.Course
import io.spring.ch03_database_querydsl.model.QCourse
import io.spring.ch03_database_querydsl.repository.CourseRepository
import jakarta.persistence.EntityManager
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.util.Lists
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class Ch03DatabaseQuerydslApplicationTests(
    @Autowired
    private val courseRepository: CourseRepository,
    @Autowired
    private val entityManager: EntityManager,
) {

    @Test
    fun givenCoursesCreatedWhenLoad() {
        courseRepository.saveAll(getCourseList())

        val cource = QCourse.course
        val query1 = JPAQuery<QCourse>(entityManager)

        query1.from(cource).where(cource.category.eq("Spring"))
        assertThat(query1.fetch().size).isEqualTo(3)

        val query2 = JPAQuery<QCourse>(entityManager)
        query2.from(cource).where(cource.category.eq("Spring").and(cource.rating.gt(3)))
        assertThat(query2.fetch().size).isEqualTo(2)

        val descOrderSpecifier = cource.rating.desc()
        assertThat(Lists.newArrayList(courseRepository.findAll(cource.category.eq("Spring"), descOrderSpecifier)).size).isEqualTo(3)
    }

    private fun getCourseList(): List<Course> {
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

        return courses
    }
}

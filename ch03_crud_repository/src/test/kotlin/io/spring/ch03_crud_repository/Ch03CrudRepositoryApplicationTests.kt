package io.spring.ch03_crud_repository

import io.spring.ch03_crud_repository.model.Course
import io.spring.ch03_crud_repository.repository.CourseRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Ch03CrudRepositoryApplicationTests(
    @Autowired
    private val courseRepository: CourseRepository,
) {

    /*
    @Test
    fun givenCreateCourse() {
        val course = Course(
            name = "Kotlin",
            category = "Programming",
            rating = 5,
            description = "Kotlin is a modern programming language that makes developers happier.",
        )

        val savedCourse = courseRepository.save(course)

        assertThat(courseRepository.findById(savedCourse.id!!).get()).isEqualTo(course)
    }

    @Test
    fun givenDeleteNoCourse() {
        val course = Course(
            name = "Kotlin",
            category = "Programming",
            rating = 5,
            description = "Kotlin is a modern programming language that makes developers happier.",
        )

        val savedCourse = courseRepository.save(course)

        assertThat(courseRepository.findById(savedCourse.id!!).get()).isEqualTo(course)

        courseRepository.delete(course)
        assertThat(courseRepository.findById(savedCourse.id!!).isPresent).isFalse
    }
     */

    @Test
    fun givenCreateCourseWhenLoadTheCourceThenExpectSameCourse() {
        courseRepository.saveAll(getCourse())

        assertThat(courseRepository.findAllByCategory("Spring")).hasSize(3)
        assertThat(courseRepository.existsByName("Javascript for All")).isTrue()
        assertThat(courseRepository.existsByName("Mastering Javascript")).isFalse()
        assertThat(courseRepository.countByCategory("Python")).isEqualTo(2)
        assertThat(courseRepository.findByNameStartsWith("Getting Started")).hasSize(1)
    }

    private fun getCourse(): MutableIterable<Course> {
        val data1 = Course(
            name = "Rapid Spring Boot Application Development",
            category = "Spring",
            rating = 4,
            description = "Kotlin is a modern programming language that makes developers happier.",
        )

        val data2 = Course(
            name = "Getting Started with Spring Cloud Kubernetes",
            category = "Spring",
            rating = 5,
            description = "Kotlin is a modern programming language that makes developers happier.",
        )

        val data3 = Course(
            name = "Master Spring Boot application deployment with Kubernetes",
            category = "Spring",
            rating = 3,
            description = "Kotlin is a modern programming language that makes developers happier.",
        )

        val data10 = Course(
            name = "Master Python application deployment with Kubernetes",
            category = "Python",
            rating = 3,
            description = "Kotlin is a modern programming language that makes developers happier.",
        )

        val data4 = Course(
            name = "Game Development with Python",
            category = "Python",
            rating = 3,
            description = "Kotlin is a modern programming language that makes developers happier.",
        )

        val data5 = Course(
            name = "Javascript for All",
            category = "Javascript",
            rating = 4,
            description = "Kotlin is a modern programming language that makes developers happier.",
        )

        val data6 = Course(
            name = "Javascript Complate Guide",
            category = "Javascript",
            rating = 5,
            description = "Kotlin is a modern programming language that makes developers happier.",
        )

        return mutableListOf(data1, data2, data3, data4, data5, data6, data10)
    }
}

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
}

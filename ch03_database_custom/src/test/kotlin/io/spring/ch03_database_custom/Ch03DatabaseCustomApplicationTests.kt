package io.spring.ch03_database_custom

import io.spring.ch03_database_custom.model.Course
import io.spring.ch03_database_custom.repository.CustomizedCourceRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class Ch03DatabaseCustomApplicationTests(
    @Autowired
    private val customizedCourceRepository: CustomizedCourceRepository,
) {

    @Test
    fun findAllTest() {
        val course = Course(
            name = "Kotlin",
            category = "Programming",
            rating = 5,
            description = "Kotlin is a programming language",
        )

        customizedCourceRepository.save(course)

        assertThat(customizedCourceRepository.findAll()).hasSize(1)
    }
}

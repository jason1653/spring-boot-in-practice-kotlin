package io.spring.ch03_database_many_to_many

import io.spring.ch03_database_many_to_many.repository.AuthorRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Ch03DatabaseManyToManyApplicationTests(
    @Autowired
    private val authorRepository: AuthorRepository,
) {

    @Test
    fun whenCountAll() {
        val data = authorRepository.getAuthorCourseInfo(2)
        assertThat(authorRepository.getAuthorCourseInfo(2)).hasSize(3)
    }
}

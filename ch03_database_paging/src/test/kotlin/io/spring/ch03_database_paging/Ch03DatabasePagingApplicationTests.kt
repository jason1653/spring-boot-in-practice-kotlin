package io.spring.ch03_database_paging

import io.spring.ch03_database_paging.repository.CourseRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort


@SpringBootTest
class Ch03DatabasePagingApplicationTests(
    @Autowired
    private val courseRepository: CourseRepository
) {

    @Test
    fun givenDataAvaliableWhenSortsFirstPageThenGetSortedSData() {
//        val pageable = PageRequest.of(0, 5, Sort.by(Sort.Order.asc("id")))

        val data = courseRepository.findAll(PageRequest.of(0, 5, Sort.by(Sort.Order.asc("id"))))
        println(data)

    }
}

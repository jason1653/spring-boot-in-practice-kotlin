package io.spring.ch07_api

import com.fasterxml.jackson.databind.ObjectMapper
import com.jayway.jsonpath.JsonPath
import io.spring.ch07_api.model.Course
import io.spring.ch07_api.service.CourseService
import org.hamcrest.Matchers.greaterThan
import org.hamcrest.Matchers.hasSize
import org.hibernate.validator.internal.util.Contracts.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.mock.http.server.reactive.MockServerHttpRequest.post
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension::class)
class Ch07ApiApplicationTests(
    @Autowired
    private val courseService: CourseService,

    @Autowired
    private val mockMvc: MockMvc,
) {

    @Test
    fun testPostCourse() {
        val course = Course()
        course.name = "Spring Boot"
        course.category = "Spring"
        course.rating = 5
        course.description = "Spring Boot Application Development"

        val objectMapper = ObjectMapper()

        val response = mockMvc.perform(
            MockMvcRequestBuilders.post("/courses/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(course)),
        )
            .andDo({ println(it.toString()) })
            .andExpect(jsonPath("$.*", hasSize<Int>(5)))
            .andExpect(jsonPath("$.id", greaterThan(0)))
            .andExpect(jsonPath("$.name").value("Spring Boot"))
            .andExpect(jsonPath("$.category").value("Spring"))
            .andExpect(jsonPath("$.rating").value(5))
            .andExpect(status().is2xxSuccessful)
            .andReturn()
            .response

        val id = JsonPath.parse(response.getContentAsString()).read("$.id", Long::class.java)

        assertNotNull(courseService.getCourseById(id))
    }

    @Test
    fun testInvalidCouseId() {
        mockMvc.perform(
            MockMvcRequestBuilders.get("/courses/{id}", 100)
                .contentType(MediaType.APPLICATION_JSON),
        )
            .andDo({ println(it.toString()) })
            .andExpect(status().isNotFound)
    }

    @Test
    fun testDeleteCourse() {
        val course = Course()
        course.name = "Spring Boot"
        course.category = "Spring"
        course.rating = 5
        course.description = "Spring Boot Application Development"

        val objectMapper = ObjectMapper()

        val response = mockMvc.perform(
            MockMvcRequestBuilders.post("/courses/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(course)),
        )
            .andDo({ println(it.toString()) })
            .andExpect(jsonPath("$.*", hasSize<Int>(5)))
            .andExpect(jsonPath("$.id", greaterThan(0)))
            .andExpect(jsonPath("$.name").value("Spring Boot"))
            .andExpect(jsonPath("$.category").value("Spring"))
            .andExpect(jsonPath("$.rating").value(5))
            .andExpect(status().is2xxSuccessful)
            .andReturn()
            .response

        val id = JsonPath.parse(response.getContentAsString()).read("$.id", Long::class.java)

        mockMvc.perform(
            MockMvcRequestBuilders.delete("/courses/{id}", id)
                .contentType(MediaType.APPLICATION_JSON),
        )
            .andDo({ println(it.toString()) })
            .andExpect(status().is2xxSuccessful)

        mockMvc.perform(
            MockMvcRequestBuilders.get("/courses/{id}", id)
                .contentType(MediaType.APPLICATION_JSON),
        )
            .andDo({ println(it.toString()) })
            .andExpect(status().isNotFound)
    }
}

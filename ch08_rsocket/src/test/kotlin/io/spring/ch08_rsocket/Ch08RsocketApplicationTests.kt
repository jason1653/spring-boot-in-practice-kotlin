package io.spring.ch08_rsocket

import io.spring.ch08_rsocket.domain.Course
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.rsocket.server.LocalRSocketServerPort
import org.springframework.messaging.rsocket.RSocketRequester
import org.springframework.messaging.rsocket.RSocketStrategies
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import kotlin.time.Duration

@SpringBootTest
class Ch08RsocketApplicationTests {

    private lateinit var requester: RSocketRequester

    @BeforeEach
    fun setup(
        @Autowired builder: RSocketRequester.Builder,
        @LocalRSocketServerPort port: Int,
        @Autowired rSocketStrategies: RSocketStrategies,
    ) {
        requester = builder.tcp("localhost", port)
   }


    @Test
    fun testRequestResponse() {
        val courseMono = requester
            .route("request-response")
            .data(Course("Spring"))
            .retrieveMono(Course::class.java)

        StepVerifier.create(courseMono)
            .expectNextMatches { course ->
                println("테스트 결과 : ${course.courseName}, ${course.courseId}, ${course.created}")
                course.courseName == "Your course name: Spring"
            }
            .verifyComplete()
    }

    @Test
    fun testFireAndForget() {
        val courseMono = requester
            .route("fire-and-forget")
            .data(Course("Spring"))
            .send()

        StepVerifier.create(courseMono)
            .verifyComplete()
    }


    @Test
    fun testRequestStream() {
        val courseFlux = requester.route("request-stream")
            .data(Course("Spring"))
            .retrieveFlux(Course::class.java)


        StepVerifier.create(courseFlux)
            .consumeNextWith { course ->
                println("테스트 결과 : ${course.courseName}, ${course.courseId}, ${course.created}")
                assertThat(course.courseName).isEqualTo("Your course name: Spring 0")
            }
            .expectNextCount(0)
            .consumeNextWith { course ->
                assertThat(course.courseName).isEqualTo("Your course name: Spring 1")
            }
            .thenCancel()
            .verify()
    }


    @Test
    fun testChannel() {
        val setting1 = Mono.just<Int>(2).delayElement(java.time.Duration.ofSeconds(0))

        val setting2 = Mono.just<Int>(1).delayElement(java.time.Duration.ofSeconds(3))

        val setting = Flux.concat(setting1, setting2)

        val stream = requester.route("stream-stream")
            .data(setting)
            .retrieveFlux(Course::class.java)

        StepVerifier
            .create(stream)
            .consumeNextWith { course ->
                println("테스트 결과 1 : ${course.courseName}, ${course.courseId}, ${course.created}")
                assertThat(course.courseName).isEqualTo("Spring. Response #0")
            }
            .consumeNextWith { course ->
                println("테스트 결과 2 : ${course.courseName}, ${course.courseId}, ${course.created}")
                assertThat(course.courseName).isEqualTo("Spring. Response #0")
            }
            .thenCancel()
            .verify()
    }

}

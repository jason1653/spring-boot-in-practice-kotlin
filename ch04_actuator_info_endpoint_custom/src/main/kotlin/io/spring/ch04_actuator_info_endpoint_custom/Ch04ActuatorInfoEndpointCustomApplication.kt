package io.spring.ch04_actuator_info_endpoint_custom

import io.spring.ch04_actuator_info_endpoint_custom.model.ReleaseItem
import io.spring.ch04_actuator_info_endpoint_custom.model.ReleaseNote
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.time.LocalDate
import java.util.LinkedHashSet

@SpringBootApplication
class Ch04ActuatorInfoEndpointCustomApplication {

    @Bean(name = ["releaseNotes"])
    fun loadReleaseNotes(): MutableSet<ReleaseNote> {
        val releaseNotes: MutableSet<ReleaseNote> = LinkedHashSet()
        val releaseNote1 = ReleaseNote(
            version = "v1.2.1",
            releaseDate = LocalDate.of(2021, 12, 30),
            commitTag = "a7d2ea3",
            bugFixes = setOf(
                ReleaseItem(
                    itemId = "BUG-123",
                    itemDescription = "Fixes a bug that caused the application to crash when a user logged in with a username that contained a space.",
                ),
            ),
        )

        val releaseNote2 = ReleaseNote(
            version = "v1.2.0",
            releaseDate = LocalDate.of(2021, 12, 15),
            commitTag = "44047f3",
            newReleases = setOf(
                ReleaseItem(
                    itemId = "NEW-123",
                    itemDescription = "Adds a new feature that allows users to log in with their email address.",
                ),
            ),
            bugFixes = setOf(
                ReleaseItem(
                    itemId = "BUG-123",
                    itemDescription = "Fixes a bug that caused the application to crash when a user logged in with a username that contained a space.",
                ),
            ),
        )

        releaseNotes.addAll(listOf(releaseNote1, releaseNote2))

        return releaseNotes
    }
}

fun main(args: Array<String>) {
    runApplication<Ch04ActuatorInfoEndpointCustomApplication>(*args)
}

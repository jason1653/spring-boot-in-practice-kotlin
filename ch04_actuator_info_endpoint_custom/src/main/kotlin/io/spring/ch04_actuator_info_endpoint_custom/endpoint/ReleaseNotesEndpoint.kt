package io.spring.ch04_actuator_info_endpoint_custom.endpoint

import io.spring.ch04_actuator_info_endpoint_custom.model.ReleaseNote
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation
import org.springframework.boot.actuate.endpoint.annotation.Endpoint
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation
import org.springframework.boot.actuate.endpoint.annotation.Selector
import org.springframework.stereotype.Component
import java.util.*

@Component
@Endpoint(id = "releaseNotes")
class ReleaseNotesEndpoint(
    @Autowired
    private val releaseNotes: MutableSet<ReleaseNote>,
) {

    @ReadOperation
    fun releaseNotes(): Iterable<ReleaseNote> {
        return releaseNotes
    }

    @ReadOperation
    fun selectCourse(@Selector version: String): Any {
        val releaseNoteOptional: Optional<ReleaseNote> = releaseNotes
            .stream()
            .filter { (version1): ReleaseNote -> version == version1 }
            .findFirst()
        return if (releaseNoteOptional.isPresent()) {
            releaseNoteOptional.get()
        } else {
            String.format("No such release version exists : %s", version)
        }
    }

    @DeleteOperation
    fun removeReleaseVersion(@Selector version: String) {
        val releaseNoteOptional: Optional<ReleaseNote> = releaseNotes
            .stream()
            .filter { (version1): ReleaseNote -> version == version1 }
            .findFirst()
        if (releaseNoteOptional.isPresent()) {
            releaseNotes.remove(releaseNoteOptional.get())
        }
    }
}

package io.spring.ch04_actuator_info_endpoint_custom.model

import java.time.LocalDate
import java.util.*

data class ReleaseNote(
    val version: String? = null,
    val releaseDate: LocalDate? = null,
    val commitTag: String? = null,
    val newReleases: Set<ReleaseItem>? = null,
    val bugFixes: Set<ReleaseItem>? = null,
) {
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o !is ReleaseNote) return false
        return version == o.version
    }

    override fun hashCode(): Int {
        return Objects.hash(version)
    }
}

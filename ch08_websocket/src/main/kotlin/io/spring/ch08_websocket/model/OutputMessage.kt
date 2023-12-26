package io.spring.ch08_websocket.model

import java.time.Instant

data class OutputMessage(
    val time: Instant,
    val content: String
)
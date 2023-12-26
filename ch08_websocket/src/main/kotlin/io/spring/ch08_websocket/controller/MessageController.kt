package io.spring.ch08_websocket.controller

import io.spring.ch08_websocket.model.InputMessage
import io.spring.ch08_websocket.model.OutputMessage
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import java.time.Clock
import java.time.Instant


@Controller
class MessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    fun message(message: InputMessage): OutputMessage {
        return OutputMessage(Instant.now(Clock.systemDefaultZone()), message.context)
    }
}
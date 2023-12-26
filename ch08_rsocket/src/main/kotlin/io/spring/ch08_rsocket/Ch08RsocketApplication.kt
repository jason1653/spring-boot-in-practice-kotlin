package io.spring.ch08_rsocket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch08RsocketApplication

fun main(args: Array<String>) {
    runApplication<Ch08RsocketApplication>(*args)
}

package io.spring.ch08_webclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch08WebclientApplication

fun main(args: Array<String>) {
    runApplication<Ch08WebclientApplication>(*args)
}

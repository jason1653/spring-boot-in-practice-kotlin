package io.spring.ch08_webflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch08WebfluxApplication

fun main(args: Array<String>) {
    runApplication<Ch08WebfluxApplication>(*args)
}

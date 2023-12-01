package io.spring.ch03_mongodb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch03MongodbApplication

fun main(args: Array<String>) {
    runApplication<Ch03MongodbApplication>(*args)
}

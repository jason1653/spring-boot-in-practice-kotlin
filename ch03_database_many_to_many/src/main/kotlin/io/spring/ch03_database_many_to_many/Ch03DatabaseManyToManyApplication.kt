package io.spring.ch03_database_many_to_many

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["io.spring.ch03_database_many_to_many.repository"])
class Ch03DatabaseManyToManyApplication

fun main(args: Array<String>) {
    runApplication<Ch03DatabaseManyToManyApplication>(*args)
}

package io.spring.ch02

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.Properties

@SpringBootApplication
class Ch02Application


fun main(args: Array<String>) {
    val context = runApplication<Ch02Application>(*args)
    val dbConfiguration = context.getBean(DbConfiguration::class.java)
    println(dbConfiguration.toString())
}

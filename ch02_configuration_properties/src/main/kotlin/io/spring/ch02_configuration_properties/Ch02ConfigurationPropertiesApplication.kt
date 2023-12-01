package io.spring.ch02_configuration_properties

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ConfigurationPropertiesScan
class Ch02ConfigurationPropertiesApplication

fun main(args: Array<String>) {
    val looger = LoggerFactory.getLogger(Ch02ConfigurationPropertiesApplication::class.java)
    val context = runApplication<Ch02ConfigurationPropertiesApplication>(*args)
    val appService = context.getBean(AppService::class.java)
    println(appService)
    looger.info(appService.toString())
}

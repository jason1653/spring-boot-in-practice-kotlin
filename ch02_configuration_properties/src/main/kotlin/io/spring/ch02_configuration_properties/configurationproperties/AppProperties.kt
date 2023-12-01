package io.spring.ch02_configuration_properties.configurationproperties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.DefaultValue

@ConfigurationProperties("app.sbip.ct")
class AppProperties(name: String, ip: String, @DefaultValue("8080") port: Int, security: Security) {
    val name: String
    val ip: String
    val port: Int
    val security: Security

    init {
        this.name = name
        this.ip = ip
        this.port = port
        this.security = security
    }

    override fun toString(): String {
        return "AppProperties{" +
            "name='" + name + '\'' +
            ", ip='" + ip + '\'' +
            ", port='" + port + '\'' +
            ", security=" + security +
            '}'
    }

}

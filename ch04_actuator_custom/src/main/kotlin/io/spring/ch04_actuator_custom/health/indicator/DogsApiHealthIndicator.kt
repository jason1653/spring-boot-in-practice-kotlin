package io.spring.ch04_actuator_custom.health.indicator

import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClientException
import org.springframework.web.client.RestTemplate

@Component
class DogsApiHealthIndicator : HealthIndicator {
    override fun health(): Health {
        try {
            val reference: ParameterizedTypeReference<Map<String?, String?>?> =
                object : ParameterizedTypeReference<Map<String?, String?>?>() {}
            val result = RestTemplate().exchange("https://dog.ceo/api/breeds/image/random", HttpMethod.GET, null, reference)

            if (result.statusCode.is2xxSuccessful && result.body != null) {
                return Health.up().withDetails(result.body).build()
            } else {
                return Health.down().withDetail("status", result.body).build()
            }
        } catch (ex: RestClientException) {
            return Health.down(ex).build()
        }
    }
}

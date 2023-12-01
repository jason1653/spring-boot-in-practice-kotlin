package io.spring.ch02_configuration_properties

import io.spring.ch02_configuration_properties.configurationproperties.AppProperties
import org.springframework.stereotype.Service

@Service
class AppService(
    private val appProperties: AppProperties
)
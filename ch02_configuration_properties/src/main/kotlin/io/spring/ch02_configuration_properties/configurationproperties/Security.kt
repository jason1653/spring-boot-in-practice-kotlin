package io.spring.ch02_configuration_properties.configurationproperties


class Security(
    val enabled: Boolean,
    var token: String,
    roles: List<String>,
) {

    val roles: List<String>

    init {
        token = token
        this.roles = roles
    }

    override fun toString(): String {
        return "Security{" +
            "enabled=" + enabled +
            ", token='" + token + '\'' +
            ", roles=" + roles +
            '}'
    }
}

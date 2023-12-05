package io.spring.ch04_custom_failure_analyzer.exception

class UrlNotAccessibleException : RuntimeException {
    var url: String? = null
        private set
    constructor(url: String) : super("URL $url is not accessible", null) {
        println("오류")
        this.url = url
    }
    constructor(url: String, cause: Throwable) : super("URL $url is not accessible", cause) {
        this.url = url
    }
}
package io.spring.ch04_custom_failure_analyzer.exception

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer
import org.springframework.boot.diagnostics.FailureAnalysis

class UrlNotAccessibleFailureAnalyzer : AbstractFailureAnalyzer<UrlNotAccessibleException>() {
    override fun analyze(rootFailure: Throwable?, cause: UrlNotAccessibleException?): FailureAnalysis {
        return FailureAnalysis(
            "URL ${cause?.url} is not accessible",
            "Check if the URL is correct and accessible",
            cause,
        )
    } }

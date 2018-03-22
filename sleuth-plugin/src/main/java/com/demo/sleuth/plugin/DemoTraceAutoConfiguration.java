package com.demo.sleuth.plugin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "demo.sleuth.config.enabled", matchIfMissing = true)
public class DemoTraceAutoConfiguration {

    @Value("${demo.sleuth.config.headers:lang_info}")
    private String[] headers;

    @Bean
    public SessionInfoFilter sessionInfoFilter(Tracer tracer) {
        return new SessionInfoFilter(headers, tracer);
    }

    @Bean
    public SessionInfoOperator sessionInfoOperator(Tracer tracer) {
        return new SessionInfoOperator(tracer);
    }
}

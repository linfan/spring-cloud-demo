package com.demo.transmission.plugin.config;

import com.demo.transmission.plugin.processor.TraceRestTemplateProcessor;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestTemplateConfig {

    @Bean
    public TraceRestTemplateProcessor traceRestTemplateBPP(ListableBeanFactory beanFactory) {
        return new TraceRestTemplateProcessor(beanFactory);
    }

}

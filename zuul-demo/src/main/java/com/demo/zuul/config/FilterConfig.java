package com.demo.zuul.config;

import com.demo.zuul.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}

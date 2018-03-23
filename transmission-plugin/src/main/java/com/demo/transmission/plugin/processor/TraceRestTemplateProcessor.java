package com.demo.transmission.plugin.processor;

import com.demo.transmission.plugin.interceptor.OutgoingInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class TraceRestTemplateProcessor implements BeanPostProcessor {

    private final BeanFactory beanFactory;

    public TraceRestTemplateProcessor(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof RestTemplate)  {
            RestTemplate rt = (RestTemplate) bean;
            List<ClientHttpRequestInterceptor> interceptors = rt.getInterceptors();
            interceptors.add(new OutgoingInterceptor());
            rt.setInterceptors(interceptors);
        }
        return bean;
    }

}

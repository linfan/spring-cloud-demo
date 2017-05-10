package com.example.eureka.client.feign.service.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "eureka-client", fallback = DemoServiceFeignClientFallback.class)
public interface DemoServiceFeignClient {
    @RequestMapping(value = "/api/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String hello();

}

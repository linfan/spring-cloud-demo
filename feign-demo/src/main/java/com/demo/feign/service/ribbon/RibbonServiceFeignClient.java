package com.demo.feign.service.ribbon;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface RibbonServiceFeignClient {

    @RequestMapping(value = "/call", method = RequestMethod.GET)
    public String call();

    @RequestMapping(value = "/backend", method = RequestMethod.GET)
    public String backend();

}

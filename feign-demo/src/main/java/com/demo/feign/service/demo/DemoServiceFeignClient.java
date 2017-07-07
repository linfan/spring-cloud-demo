package com.demo.feign.service.demo;

import com.demo.feign.vo.Info;
import com.demo.feign.vo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "eureka-client", fallback = DemoServiceFeignClientFallback.class)
public interface DemoServiceFeignClient {

    @RequestMapping(value = "/api/hello/{name}", method = RequestMethod.GET)
    public User hello(@PathVariable("name") String name);

    @RequestMapping(value = "/api/{greeting}", method = RequestMethod.POST)
    public User greeting(@PathVariable("greeting") String greeting, @RequestBody User user);

    @RequestMapping(value = "/api/info", method = RequestMethod.GET)
    public Info info();

}

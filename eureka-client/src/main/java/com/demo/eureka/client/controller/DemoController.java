package com.demo.eureka.client.controller;

import com.demo.eureka.client.vo.Info;
import com.demo.eureka.client.vo.User;
import com.netflix.appinfo.InstanceInfo;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api")
public class DemoController {

	@Autowired
    private EurekaRegistration registration;
	
	@Value("${demo.env}")
	private String env;

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public User hello(@ApiParam(required=true, name="name", value="用户名") @PathVariable String name) {
        return new User("hello", name);
    }

    @RequestMapping(value = "/{greeting}", method = RequestMethod.POST)
    public User hello(
    		@ApiParam(required=true, name="greeting", value="自定义问候语") @PathVariable String greeting, 
    		@RequestBody User user) {
        return new User(greeting, user.getName());
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Info hello() {
        InstanceInfo instanceInfo = registration.getApplicationInfoManager().getInfo();
        return new Info(registration.getServiceId(), env,
                instanceInfo.getHostName() + ":" + instanceInfo.getPort());
    }

}

package com.demo.eureka.client.feign.controller;

import com.demo.eureka.client.feign.service.demo.DemoServiceFeignClient;
import com.demo.eureka.client.feign.vo.Info;
import com.demo.eureka.client.feign.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@Autowired
	private DemoServiceFeignClient demoServiceFeignClient;

	@RequestMapping(value = "/call", method = RequestMethod.GET)
	public String call() {
	    User mike = demoServiceFeignClient.greeting("hey", new User("hi", "mike"));
	    User lucy = demoServiceFeignClient.hello("Lucy");
		return "when i say \"hey\" to " + mike.getName() + " and he answered me \"" + mike.getGreeting()
            + "\". then i call " + lucy.getName() + " and she say \"" + lucy.getGreeting() + "\".";
	}

    @RequestMapping(value = "/backend", method = RequestMethod.GET)
    public String backend() {
        Info info = demoServiceFeignClient.info();
        return "Called " + info.getName() + "(" + info.getEnv() + ") @ " + info.getAddress();
    }
}

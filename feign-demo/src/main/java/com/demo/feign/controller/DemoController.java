package com.demo.feign.controller;

import com.demo.feign.service.demo.DemoServiceFeignClient;
import com.demo.feign.service.ribbon.RibbonServiceFeignClient;
import com.demo.feign.vo.Info;
import com.demo.feign.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@Autowired
	private DemoServiceFeignClient demoServiceFeignClient;

	@Autowired
    private RibbonServiceFeignClient ribbonServiceFeignClient;

	@RequestMapping(value = "/call", method = RequestMethod.GET)
	public String call() {
	    User mike = demoServiceFeignClient.greeting("hey", new User("hi", "mike"));
	    User lucy = demoServiceFeignClient.hello("Lucy");
		return "when i say \"hi\" to " + mike.getName() + " and he answered me \"" + mike.getGreeting()
            + "\". then i call " + lucy.getName() + " and she say \"" + lucy.getGreeting() + "\".";
	}

    @RequestMapping(value = "/backend", method = RequestMethod.GET)
    public String backend() {
        Info info = demoServiceFeignClient.info();
        return "Called " + info.getName() + "(" + info.getEnv() + ") @ " + info.getAddress();
    }

    @RequestMapping(value = "/ribbon/call", method = RequestMethod.GET)
    public String ribbonCall() {
        return "Ribbon tells: " + ribbonServiceFeignClient.call();
    }

    @RequestMapping(value = "/ribbon/backend", method = RequestMethod.GET)
    public String ribbonBackend() {
        return "Ribbon tells: " + ribbonServiceFeignClient.backend();
    }
}

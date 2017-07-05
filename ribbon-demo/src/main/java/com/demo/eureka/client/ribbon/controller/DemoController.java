package com.demo.eureka.client.ribbon.controller;

import com.demo.eureka.client.ribbon.service.DemoRibbonRestClient;
import com.demo.eureka.client.ribbon.vo.Info;
import com.demo.eureka.client.ribbon.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {

	@Autowired
    DemoRibbonRestClient demoRibbonRestClient;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String tryGet() {
		User user = demoRibbonRestClient.getUser("demo");
		return user.getGreeting() + " " + user.getName() + "!";
	}

	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String tryPost() {
		User user = demoRibbonRestClient.postUser("hi", "demo");
		return user.getGreeting() + " " + user.getName() + "!";
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info() {
		Info info = demoRibbonRestClient.getInfo();
		return "Called " + info.getName() + "(" + info.getEnv() + ") @ " + info.getAddress();
	}

}

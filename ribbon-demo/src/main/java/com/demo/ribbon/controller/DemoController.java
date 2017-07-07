package com.demo.ribbon.controller;

import com.demo.ribbon.service.DemoRibbonRestClient;
import com.demo.ribbon.vo.Info;
import com.demo.ribbon.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {

	@Autowired
    DemoRibbonRestClient demoRibbonRestClient;

	@RequestMapping(value = "/call", method = RequestMethod.GET)
	public String call() {
		User mike = demoRibbonRestClient.postUser("hey", "mike", "hi");
		User lucy = demoRibbonRestClient.getUser("Lucy");
		return "when i say \"hi\" to " + mike.getName() + " and he answered me \"" + mike.getGreeting()
				+ "\". then i call " + lucy.getName() + " and she say \"" + lucy.getGreeting() + "\".";
	}

	@RequestMapping(value = "/backend", method = RequestMethod.GET)
	public String backend() {
		Info info = demoRibbonRestClient.getInfo();
		return "Called " + info.getName() + "(" + info.getEnv() + ") @ " + info.getAddress();
	}

}

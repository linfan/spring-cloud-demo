package com.demo.eureka.client.ribbon.service;

import com.demo.eureka.client.ribbon.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.demo.eureka.client.ribbon.vo.Info;

@Component
public class DemoRibbonRestClient {
	
	@Autowired
	private RestTemplate restTemplate;

    public User getUser(String userName) {
        return restTemplate.getForEntity( "http://eureka-client/api/hello/" + userName,
                User.class).getBody();
    }

    public User postUser(String greeting, String userName) {
        return restTemplate.postForEntity( "http://eureka-client/api/" + greeting,
                new User("", userName), User.class).getBody();
    }

    public Info getInfo() {
        return restTemplate.getForEntity( "http://eureka-client/api/info", Info.class).getBody();
    }
}
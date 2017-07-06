package com.demo.eureka.client.ribbon.service;

import com.demo.eureka.client.ribbon.vo.Info;
import com.demo.eureka.client.ribbon.vo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DemoRibbonRestClient {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getUserFallback")
    public User getUser(String userName) {
        return restTemplate.getForEntity("http://eureka-client/api/hello/" + userName,
                User.class).getBody();
    }

    @HystrixCommand(fallbackMethod = "postUserFallback")
    public User postUser(String greeting, String userName, String userGreeting) {
        return restTemplate.postForEntity("http://eureka-client/api/" + greeting,
                new User(userGreeting, userName), User.class).getBody();
    }

    @HystrixCommand(fallbackMethod = "getInfoFallback")
    public Info getInfo() {
        return restTemplate.getForEntity("http://eureka-client/api/info", Info.class).getBody();
    }

    public User getUserFallback(String userName) {
        return new User("i'm not here", userName);
    }

    public User postUserFallback(String greeting, String userName, String userGreeting) {
        return new User("i'll be back soon...", userName);
    }

    public Info getInfoFallback() {
        return new Info("none", "default", "no where");
    }

}
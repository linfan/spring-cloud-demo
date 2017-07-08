package com.demo.ribbon.service;

import com.demo.ribbon.vo.Info;
import com.demo.ribbon.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DemoRibbonRestClient {

    @Autowired
    private RestTemplate restTemplate;

    public User getUser(String userName) {
        return restTemplate.getForEntity("http://eureka-client/api/hello/" + userName,
                User.class).getBody();
    }

    public User postUser(String greeting, String userName, String userGreeting) {
        return restTemplate.postForEntity("http://eureka-client/api/" + greeting,
                new User(userGreeting, userName), User.class).getBody();
    }

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
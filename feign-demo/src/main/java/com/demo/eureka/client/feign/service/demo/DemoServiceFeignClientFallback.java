package com.demo.eureka.client.feign.service.demo;

import com.demo.eureka.client.feign.vo.Info;
import com.demo.eureka.client.feign.vo.User;
import org.springframework.stereotype.Component;

@Component
public class DemoServiceFeignClientFallback implements DemoServiceFeignClient {

	@Override
	public User hello(String name) {
		return new User("i'm not here", name);
	}

	@Override
	public User greeting(String greeting, User user) {
		return new User("i'll be back soon...", user.getName());
	}

	@Override
	public Info info() {
		return null;
	}
}

package com.demo.feign.service.demo;

import com.demo.feign.vo.Info;
import com.demo.feign.vo.User;
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
		return new Info("none", "default", "no where");
	}
}

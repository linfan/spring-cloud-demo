package com.demo.feign.service.ribbon;

import org.springframework.stereotype.Component;

@Component
public class RibbonServiceFeignClientFallback implements RibbonServiceFeignClient {

	@Override
	public String call() {
		return "call failed";
	}

	@Override
	public String backend() {
		return "i'm not there";
	}
}

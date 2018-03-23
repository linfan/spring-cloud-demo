package com.demo.feign.service.ribbon;

import feign.Param;
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

	@Override
	public String trace(@Param("id") String id) {
		return "fail to find trace";
	}
}

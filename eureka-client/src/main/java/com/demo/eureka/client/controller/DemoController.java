package com.demo.eureka.client.controller;

import com.demo.eureka.client.vo.User;
import com.google.common.collect.ImmutableMap;
import com.netflix.appinfo.InstanceInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import java.util.Map;

/**
 * ApiOperation和ApiParam可理解为API说明
 */
@RestController
@RequestMapping(value="/api/hello")
public class DemoController {
	@Autowired
    private EurekaRegistration registration;
	
	@Value("${demo.env}")
	private String env;

	@ApiOperation(value="演示从配置文件读取信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String, String> hello() {
        return ImmutableMap.of("hello", env);
    }
	
	@ApiOperation(value="演示从环境上下文读取信息")
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Map<String, String> hello(@ApiParam(required=true, name="name", value="用户名") @PathVariable String name) {
        InstanceInfo instanceInfo = registration.getApplicationInfoManager().getInfo();
        return ImmutableMap.of("name", registration.getServiceId(),
                "address", instanceInfo.getHostName() + ":" + instanceInfo.getPort());
    }
	
	@ApiOperation(value="演示处理POST请求")
    @RequestMapping(value = "/{greeting}", method = RequestMethod.POST)
    public Map<String, String> hello(
    		@ApiParam(required=true, name="greeting", value="自定义问候语") @PathVariable String greeting, 
    		@RequestBody User user) {
        return ImmutableMap.of(greeting, user.getName());
    }
	
	/**
	 * ApiIgnore注解用于Controller层，当前Controller所有方法不可见
	 * ApiIgnore注解用于方法层，当前方法不可见
	 * ApiIgnore注解用于参数层，当前属性不可见
	 */
	@ApiIgnore
	@ApiOperation(value="演示@ApiIgnore")
    @RequestMapping(value = "/testIgnore/{name}", method = RequestMethod.POST)
    public String testIgnore(@ApiParam(required=true, name="name", value="用户名") @PathVariable String name) {
        return "Hello! " + name;
    }
}

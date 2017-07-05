package com.demo.eureka.client.controller;

import com.demo.eureka.client.vo.User;
import com.netflix.appinfo.InstanceInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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

	@ApiOperation(value="演示从环境上下文和配置文件读取信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String hello() {
        InstanceInfo instanceInfo = registration.getApplicationInfoManager().getInfo();
        return "Hello! It's " + env  + ". " + registration.getServiceId() +
                ":" + instanceInfo.getHostName() + ":" + instanceInfo.getPort();
    }
	
	@ApiOperation(value="演示GET请求参数")
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String hello(@ApiParam(required=true, name="name", value="用户名") @PathVariable String name) {
        return "Hello! " + name;
    }
	
	@ApiOperation(value="演示POST请求实体")
    @RequestMapping(value = "/{greeting}", method = RequestMethod.POST)
    public String hello(
    		@ApiParam(required=true, name="greeting", value="自定义问候语") @PathVariable String greeting, 
    		@RequestBody User user) {
        return greeting + "! " + user.getUserName();
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

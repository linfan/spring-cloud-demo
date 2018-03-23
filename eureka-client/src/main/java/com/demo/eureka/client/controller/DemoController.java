package com.demo.eureka.client.controller;

import com.demo.eureka.client.vo.Info;
import com.demo.eureka.client.vo.User;
import com.netflix.appinfo.InstanceInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * ApiOperation和ApiParam可理解为API说明
 */
@RestController
@RequestMapping(value="/api")
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(DemoController.class);

	@Autowired
    private EurekaRegistration registration;

    @Value("${demo.env}")
	private String env;

	@ApiOperation(value="演示处理GET请求")
    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public User hello(@ApiParam(required=true, name="name", value="用户名") @PathVariable String name) {
        return new User("hello", name);
    }

	@ApiOperation(value="演示处理POST请求")
    @RequestMapping(value = "/{greeting}", method = RequestMethod.POST)
    public User hello(
    		@ApiParam(required=true, name="greeting", value="自定义问候语") @PathVariable String greeting, 
    		@RequestBody User user) {
        return new User(greeting, user.getName());
    }

    @ApiOperation(value="演示从环境上下文和配置文件读取信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Info hello() {
        InstanceInfo instanceInfo = registration.getApplicationInfoManager().getInfo();
        return new Info(registration.getServiceId(), env,
                instanceInfo.getHostName() + ":" + instanceInfo.getPort());
    }

    @ApiOperation(value="演示HTTP透传Trace信息")
    @RequestMapping(value = "/trace", method = RequestMethod.GET)
    public String trace(@RequestHeader HttpHeaders headers) {
        List<String> userId = headers.get("x-user-id");
        return userId == null ? "Trace not found" : userId.get(0);
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

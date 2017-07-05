package com.demo.config.client.controller;

import com.google.common.collect.ImmutableMap;
import com.netflix.appinfo.InstanceInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value="/api/")
public class DemoController {

    @Autowired
    private EurekaRegistration registration;

	@Value("${demo.config.item}")
	private String item;

    @ApiOperation(value="演示从环境上下文和配置文件读取信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Map<String, String> hello() {
        InstanceInfo instanceInfo = registration.getApplicationInfoManager().getInfo();
        return ImmutableMap.of("serviceId", registration.getServiceId(),
                "serviceListen", instanceInfo.getHostName() + ":" + instanceInfo.getPort(),
                "configItem", item);
    }

}

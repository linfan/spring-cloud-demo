package com.demo.feign.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("服务运行信息")
public class Info {

    @ApiModelProperty("服务名称")
	private String name;
    @ApiModelProperty("服务运行环境")
    private String env;
    @ApiModelProperty("服务运行地址")
    private String address;

    public Info() {
    }

    public Info(String name, String env, String address) {
        this.name = name;
        this.env = env;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

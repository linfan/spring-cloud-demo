package com.demo.eureka.client.ribbon.vo;

public class Info {
	
	private String name;
    private String env;
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

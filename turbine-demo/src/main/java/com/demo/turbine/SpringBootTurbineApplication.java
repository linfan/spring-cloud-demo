package com.demo.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTurbineApplication.class, args);
	}
}

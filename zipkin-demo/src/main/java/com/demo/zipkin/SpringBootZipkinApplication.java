package com.demo.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootZipkinApplication.class, args);
	}
}

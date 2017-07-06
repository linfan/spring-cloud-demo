package com.demo.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

@EnableDiscoveryClient
@EnableZipkinServer
@SpringBootApplication
public class SpringBootSleuthZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSleuthZipkinApplication.class, args);
	}
}

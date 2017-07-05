# config-client

演示Config Client

|url|desc|  
|:---|:---|   
|http://localhost:8085/swagger-ui.html|Eureka客户端接口列表|  
|http://localhost:8085/env|观察配置的加载位置和顺序|   

## 配置Config Client
* 引入Maven依赖  

``` maven
<!-- spring cloud config　客户端 -->
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

* 配置ConfigServer地址  

_spring.application.name指定该工程的服务名_  
_spring.profiles.active读取指定环境的配置文件（如：application-dev.properties、eureka-client-dev.properties）_  
_spring.cloud.config.uri指定ConfigServer的地址_  
_server.port指定端口_  

``` yml
spring:
  application:
    name: eureka-client
  profiles:
    active: dev
  cloud:
    config:
      uri: ${config.server.uri:http://localhost:8888} 

server:
  port: 8081
```

* 获取远程服务器文件属性值  

_通过@Value("${属性名}")获取属性值，见DemoController类hello()_  

``` java
@Value("${demo.env}")
private String env;
```
  
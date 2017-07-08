# Eureka Server

Eureka服务注册中心

|method|url|desc|
|:---|:---|:---|
|GET|http://localhost:8761|Eureka服务中心|

## 练习一：服务发现和负载均衡

* 引入Maven依赖

``` maven
<!-- eureka server -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka-server</artifactId>
</dependency>
```

* 配置Eureka Server

``` yml
eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false  # 不注册自己到Eureka服务中心
    fetchRegistry: false       # 从Eureka服务中心获取注册信息
```

* 启用Eureka Server  

``` java
@EnableEurekaServer
```

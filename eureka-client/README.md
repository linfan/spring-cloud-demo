# Eureka Client

Eureka的客户端，提供Restful服务

|method|url|desc|
|:---|:---|:---|
|GET|http://localhost:8081/swagger-ui.html|Eureka客户端接口列表|
|GET|http://localhost:8081/api/hello/{name}|演示处理GET请求|
|POST|http://localhost:8081/api/{greeting}|演示处理POST请求|
|GET|http://localhost:8081/api/info}|演示从环境上下文和配置文件读取信息|

## 练习一：服务发现和负载均衡

* 引入Maven依赖  

``` maven
<!-- eureka client -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
```

* 配置Eureka服务注册地址

``` yml
eureka:
  instance:
    leaseRenewalIntervalInSeconds: 10     # 心跳间隔（秒），默认30s
    leaseExpirationDurationInSeconds: 30  # 失效时间，默认90s
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
    healthcheck:
      enabled: true
```

> 注：增加leaseRenewalIntervalInSeconds和leaseExpirationDurationInSeconds配置，可避免EurekaServer界面以下警告：_  
> ```
> EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.
> ```

* 启用EurekaClient  

``` java
@EnableDiscoveryClient
```

* 启动两个Eureka Client  

``` bash
mvn spring-boot:run -Dspring.profiles.active=dev1
mvn spring-boot:run -Dspring.profiles.active=dev2
```

## 练习四：服务监控

* 配置允许访问监控端点

``` yml

endpoints:
  metrics:
    enabled: true
    sensitive: false
  dump:
    enabled: true
    sensitive: false
  env:
    enabled: true
    sensitive: false
  trace:
    enabled: true
    sensitive: false
  heapdump:
    enabled: true
    sensitive: false
```

* 引入Zipkin和Sleuth的Maven依赖  

``` maven
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-sleuth-zipkin</artifactId>
</dependency>
```

* 配置Zipkin

``` yml
spring:
  zipkin:
    base-url: http://localhost:9966
  sleuth:
    enabled: true
    sampler:
      percentage: 1
```

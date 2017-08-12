# Feign Demo

Feign封装的Restful调用

|method|url|desc|  
|:---|:---|:---|  
|GET|http://localhost:8182/swagger-ui.html|Ribbon客户端接口列表|
|GET|http://localhost:8182/call|使用Ribbon访问EurekaClient服务|
|GET|http://localhost:8182/backend|显示访问的EurekaClient服务信息|

## 练习一：服务发现和负载均衡

* 引入Maven依赖  

``` maven
<!-- feign -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-feign</artifactId>
</dependency>
```

* 启用FeignClient  

_spring boot启动类增加@EnableFeignClients注解，使其自动扫描@FeignClient_  

``` java
@EnableFeignClients
```

* 标识Feign代理服务

``` java
@FeignClient(value = "eureka-client")
@FeignClient(value = "ribbon-demo")
```

## 练习三：故障熔断

* 引入Maven依赖

``` maven
<!-- hystrix -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-hystrix</artifactId>
</dependency>
```

* 启用Hystrix

``` java
@EnableHystrix
```

* 配置Feign的Fallback

``` java
@FeignClient(value = "eureka-client", fallback = DemoServiceFeignClientFallback.class)
@FeignClient(value = "ribbon-demo", fallback = RibbonServiceFeignClientFallback.class)

```

## 练习四：服务监控

* 配置允许访问监控端点

``` yaml
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
<!-- zipkin & sleuth -->
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

``` yaml
spring:
  zipkin:
    base-url: http://localhost:9966
  sleuth:
    enabled: true
    sampler:
      percentage: 1
```

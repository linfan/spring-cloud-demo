# Ribbon demo

Ribbon负载均衡器

|method|url|desc|
|:---|:---|:---|
|GET|http://localhost:8181/swagger-ui.html|Ribbon客户端接口列表|
|GET|http://localhost:8181/call|使用Ribbon访问EurekaClient服务|
|GET|http://localhost:8181/backend|显示访问的EurekaClient服务信息|

## 练习一：服务发现和负载均衡

* 引入Maven依赖

``` maven
<!-- ribbon -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-ribbon</artifactId>
</dependency>
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

* 添加Fallback注解

``` java
@HystrixCommand(fallbackMethod = "getUserFallback")
@HystrixCommand(fallbackMethod = "postUserFallback")
@HystrixCommand(fallbackMethod = "getInfoFallback")
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
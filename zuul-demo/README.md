# Zuul Demo

微服务网关

|method|url|desc|  
|:---|:---|:---|   
|GET|http://localhost:5555/eureka/api/info|访问eureka-client服务的info方法|
|GET|http://localhost:5555/ribbon/backend|获取ribbon-demo服务的backend方法|

## 练习五：服务网关

* 引入Maven依赖  

``` maven
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-zuul</artifactId>
</dependency>
```

* 配置接口  

_serviceId指定服务名_  
_url指定服务地址_

``` yaml
zuul:
  routes:
    eureka-client:
      serviceId: eureka-client
      path: /eureka/**
      stripPrefix: true
    ribbon-demo:
      path: /ribbon/**
      url: http://localhost:8181/
```

_Zuul默认自带断路功能，最好设置Hystrix的全局超时时间，例如设置默认超时时间为6s_  

``` yml
hystrix:
  command:
    default:
      execution:
        isolation:
          thread:
            timeoutInMilliseconds: 6000
```

* 启用Zuul

_增加@EnableZuulProxy注解，启用Zuul_

``` java
@EnableZuulProxy
```

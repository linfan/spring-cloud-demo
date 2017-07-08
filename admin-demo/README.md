# Admin Demo 

SpringBoot应用监控，管理和监控基于Spring Boot的应用

|method|url|desc|
|:---|:---|:---|
|GET|http://localhost:8090|spring boot admin ui|

## 练习四：服务监控

* 引入Maven依赖  

``` maven
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-server</artifactId>
    <version>1.5.2</version>
</dependency>
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-server-ui</artifactId>
    <version>1.5.2</version>
</dependency>
```

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

* 启用AdminServer  

_增加@EnableAdminServer，启用Spring Boot Admin_  

``` java
@EnableAdminServer
```

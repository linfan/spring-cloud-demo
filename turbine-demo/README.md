# Turbine Demo

断路器汇聚，Hystrix Dashboard监控

|url|desc|
|:---|:---|
|http://localhost:9090/hystrix|查看仪表盘|
|http://localhost:9090/hystrix.stream|在仪表盘中增加监控|  
|http://localhost:9090/turbine.stream|在仪表盘中增加监控|  

## 练习四：服务监控

* 引入Maven依赖  

``` maven
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-turbine</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
</dependency>
```  

*　启用Hystrix Dashboard

_spring boot启动类增加@EnableHystrixDashboard注解，启用Hystrix Dashboard_  

``` java
@EnableTurbine
@EnableHystrixDashboard
```

*　配置Hystrix Stream汇聚

``` yaml
turbine:
  appConfig: feign-demo,ribbon-demo
  clusterNameExpression: new String("default")
  aggregator:
    clusterConfig: default
```

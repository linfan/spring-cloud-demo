# turbine-demo


_Hystrix Dashboard监控_  

|url|desc|  
|:---|:---|    
|http://localhost:8182/hystrix|查看仪表盘|
|http://localhost:8181/hystrix.stream|在仪表盘中增加监控|  
|http://localhost:8182/turbine.stream|在仪表盘中增加监控|  

* 引入Maven依赖  

``` maven
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
</dependency>
```  

*　启用Hystrix Dashboard  

_spring boot启动类增加@EnableHystrixDashboard注解，启用Hystrix Dashboard_  

``` java
@EnableHystrixDashboard
```

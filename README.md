# Spring Cloud Demo  

Spring Cloud相关练习，包含服务发现/配置中心/故障熔断/服务监控/服务网关等场景。

GitHub：<https://github.com/linfan/spring-cloud-demo.git> <br>
Forked from：<https://github.com/luoml/spring-cloud-example.git>  

_项目基于Spring Boot `1.5.4.RELEASE`和Spring Cloud `Dalston.RELEASE`版本，各模块简要说明如下：_

## 服务清单

|project|desc|
|---|---|
|[eureka-server](eureka-server/README.md)|演示Eureka服务注册中心|
|[eureka-client](eureka-client/README.md)|演示Eureka的客户端，提供Restful服务|
|[ribbon-demo](ribbon-demo/README.md)|演示Ribbon负载均衡器，以及Hystrix断路器|
|[feign-demo](feign-demo/README.md)|演示Feign封装调用，以及Hystrix断路器|  
|[config-server](config-server/README.md)|演示分布式配置中心|
|[config-client](config-client/README.md)|演示配置中心客户端，动态更新配置|
|[config-repo](config-repo/README.md)|配置中心的Git远程仓库|
|[admin-server](admin-server/README.md)|演示SpringBoot应用监控|
|[turbine-demo](turbine-demo/README.md)|演示断路器汇聚监控|
|[zipkin-demo](zipkin-demo/README.md)|演示服务调用链追踪|
|[zuul-demo](zuul-demo/README.md)|演示Zuul服务网关|
|[db-rest-demo](rest-demo/README.md)|演示Spring Data REST自动创建数据接口|
|[transmission-plugin](transmission-plugin/README.md)|演示HTTP链路数据透传|

## 练习目录

- 练习一：服务发现，通过服务发现进行服务调用负载均衡 <br>
需要服务`eureka-server`/`eureka-client`x2/`ribbon-demo`/`feign-demo`
- 练习二：配置中心，通过配置中心进行配置热刷新 <br>
需要服务`eureka-server`/`config-server`/`config-client`x2
- 练习三：故障熔断，通过故障熔断阻止故障雪崩 <br>
需要服务`eureka-server`/`eureka-client`/`feign-demo`
- 练习四：服务监控，通过性能面板和调用链追踪优化服务 <br>
需要服务`eureka-server`/`eureka-client`/`ribbon-demo`/`feign-demo`/`admin-demo`/`turbine-demo`/`zipkin-demo`
- 练习五：服务网关，通过服务网关控制访问流量 <br>
需要服务`eureka-server`/`eureka-client`/`ribbon-demo`/`zuul-demo`

## 特别说明

- `eureka-client`、`ribbon-demo`和`feign-demo`服务中已经引入了`Zipkin`的依赖，在练习一会出现`ResourceAccessException`，需要先移除相关代码
- `config-server`和`config-client`中引入的Spring Cloud Bus包含对Rabbit的依赖，在练习二尚未使用动态刷新时，可先移除相关代码

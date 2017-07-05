## Spring Cloud Demo  

Spring Cloud相关DEMO，包含服务发现/配置中心/故障熔断/服务监控/服务网关等场景。  

GitHub：<https://github.com/linfan/spring-cloud-demo.git> <br>
Forked from：<https://github.com/luoml/spring-cloud-example.git>  

_项目基于Spring Boot `1.5.4.RELEASE`和Spring Cloud `Dalston.RELEASE`版本，各模块简要说明如下：_

|project|desc|
|---|---|
|[eureka-server](eureka-server/README.md)|Eureka服务注册中心|
|[eureka-client](eureka-client/README.md)|Eureka的客户端，提供Restful服务|
|[ribbon-demo](ribbon-demo/README.md)|使用Ribbon负载均衡器访问EurekaClient的接口|
|[config-server](config-server/README.md)|分布式配置中心|
|[config-client](config-client/README.md)|从配置服务中获得启动参数的Restful服务|
|[config-repo](config-repo/README.md)|服务配置的Git远程仓库|
|[feign-demo](feign-demo/README.md)|Eureka客户端，集成Feign、Hystrix等|  
|[api-gateway](api-gateway/README.md)|Zuul服务网关|
|[admin-server](admin-server/README.md)|监控基于Spring Boot的应用|
|[rest-demo](rest-demo/README.md)|Spring Data JPA和Spring Data REST的演示|

演示目录：

- 1. 服务发现，通过服务发现进行服务调用负载均衡 <br>
涉及项目`eureka-server`/`eureka-client`/`ribbon-demo`
- 2. 配置中心，通过配置中心进行配置热刷新 <br>
涉及项目`config-server`/`config-client`/`config-repo`
- 3. 故障熔断，通过故障熔断阻止故障雪崩 <br>
涉及项目`eureka-server`/`eureka-client`/`feign-demo`
- 4. 服务监控，通过性能面板和调用链追踪优化服务 <br>
涉及项目`admin-server`/`hystrix-dashboard`/`sleuth-server`
- 5. 服务网关，通过服务网关控制访问流量 <br>
涉及项目`eureka-server`/`eureka-client`/`api-gateway`

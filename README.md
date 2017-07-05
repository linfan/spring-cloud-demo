
## Spring Cloud Demo  

Spring Cloud相关DEMO，包含zuul\eureka\swagger2\feign\hystrix\spring cloud config\spring data rest等。  

GitHub：<https://github.com/linfan/spring-cloud-demo.git> <br>
Forked from：<https://github.com/luoml/spring-cloud-example.git>  


_项目基于Spring Boot `1.5.4.RELEASE`和Spring Cloud `Dalston.RELEASE`版本，各模块简要说明如下：_

|project|desc|
|---|---|  
|[config-repo](config-repo/README.md)|Git远程仓库|  
|[config-server](config-server/README.md)|Spring Cloud Config Server，从config-repo拉取配置清单|  
|[eureka-server](eureka-server/README.md)|Eureka服务注册中心|  
|[eureka-client](eureka-client/README.md)|Eureka与Config客户端，集成了Swagger2等|  
|[rest-demo](rest-demo/README.md)|数据库增删改查<br>涉及Eureka Client、Spring Data JPA、Spring Data REST、H2、the HAL Browser等|  
|[feign-demo](feign-demo/README.md)|Eureka客户端，集成了Feign、Hystrix等|  
|[api-gateway](api-gateway/README.md)|Zuul服务网关|  
|[admin-server](admin-server/README.md)|监控基于Spring Boot的应用|  
|...|...|  

> 演示目录：
> 1. 服务发现，通过服务发现进行服务调用负载均衡 <br>
涉及项目`eureka-server`/`eureka-client`/`ribbon-demo`
> 2. 配置中心，通过配置中心进行配置热刷新 <br>
涉及项目`config-server`/`config-client`/`config-repo`
> 3. 故障熔断，通过故障熔断阻止故障雪崩 <br>
涉及项目`eureka-server`/`eureka-client`/`feign-demo`
> 4. 服务监控，通过性能面板和调用链追踪优化服务 <br>
涉及项目`admin-server`/`hystrix-dashboard`/`sleuth-server`
> 5. 服务网关，通过服务网关控制访问流量 <br>
涉及项目`eureka-server`/`eureka-client`/`api-gateway`

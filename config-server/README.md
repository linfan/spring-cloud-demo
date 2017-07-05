# config-server

本模块主要演示Spring Cloud Config Server。  

ConfigServer使用Git或SVN仓库管理配置，当其收到来自客户端的配置获取请求后，会将远程仓库的配置clone到本地的临时目录，然后从本地读取配置并返回。  

|url|desc|  
|:---|:---|   
|http://localhost:8888/{application}/{profile}[/{label*}]|配置访问地址|  
|http://localhost:8888/config-client.yml|获得config-client服务默认profile的原始配置|
|http://localhost:8888/config-client/default|获得config-client服务默认profile的配置内容|
|http://localhost:8888/config-client-dev.yml|获得config-client服务dev profile的原始配置|
|http://localhost:8888/config-client/dev|获得config-client服务dev profile的配置内容|

> *lable指的是Git仓库的分支或标签

- 引入Maven依赖

``` maven
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

- 配置仓库地址

_spring.cloud.config.server.git.uri配置git仓库地址，集中管理服务配置信息_  
_searchPaths指定扫描路径_

``` yml
spring:
  application:
    name: config-server 
  cloud:
    config:
      server:
        git:
          uri: ${config.repo.uri:https://github.com/linfan/spring-cloud-demo}
          searchPaths: config-repo

server:
  port: 8888
```

- 启用ConfigServer

_增加@EnableConfigServer，启用Config Server_  

``` java
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
```

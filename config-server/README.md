# Config Server

分布式配置中心

ConfigServer使用Git或SVN仓库管理配置，当其收到来自客户端的配置获取请求后，会将远程仓库的配置clone到本地的临时目录，然后从本地读取配置并返回。  

|method|url|desc| 
|:---|:---|:---|   
|GET|http://localhost:8888/{application}/{profile}[/{label*}]|配置访问地址|
|GET|http://localhost:8888/config-client.yml|获得config-client服务默认profile的原始配置|
|GET|http://localhost:8888/config-client/default|获得config-client服务默认profile的配置内容|
|GET|http://localhost:8888/config-client-dev.yml|获得config-client服务dev profile的原始配置|
|GET|http://localhost:8888/config-client/dev|获得config-client服务dev profile的配置内容|

> *lable指的是Git仓库的分支或标签

## 练习二：配置中心和动态配置刷新

* 引入Maven依赖

``` maven
<!-- Config Server -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

* 配置Gi仓库

_spring.cloud.config.server.git.uri配置git仓库地址，集中管理服务配置信息_  
_searchPaths指定扫描路径_

``` yaml
spring:
  cloud:
    config:
      server:
        git:
          uri: /Users/flin/Workspace/spring-cloud/spring-cloud-example/.git
          searchPaths: config-repo
```

* 启用ConfigServer

_增加@EnableConfigServer，启用Config Server_  

``` java
@EnableConfigServer
```

* 引入Bus依赖

``` maven
<!-- Bus refresh -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>
```

* 配置MQ地址

``` yaml
spring:
  rabbitmq:
    host: localhost
    port: 5672
```

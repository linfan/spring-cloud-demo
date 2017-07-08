# Config Client

配置中心客户端，动态更新配置

|method|url|desc|  
|:---|:---|:---|   
|GET|http://localhost:8085/swagger-ui.html|Eureka客户端接口列表|  
|GET|http://localhost:8085/env|观察配置的加载位置和顺序|   
|GET|http://localhost:8085/refresh|刷新单个服务配置|
|GET|http://localhost:8085/bus/refresh|通过MQ刷新所有服务配置|
|GET|http://localhost:8085/info|从环境上下文和配置文件读取信息|

## 练习二：配置中心和动态配置刷新

### 使用配置中心

* 引入Maven依赖

``` maven
<!-- spring cloud config client -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

* 配置ConfigServer地址

``` yaml
spring:
  cloud:
    config:
      uri: http://localhost:8888
```

* 允许查看配置加载的路由

``` yaml
endpoints:
  env:
    enabled: true
    sensitive: false
```

### 单服务配置动态更新

* 运行两个实例

```bash
mvn spring-boot:run -Dserver.port=8085
mvn spring-boot:run -Dserver.port=8086
```

* 允许配置刷新

``` java
@RefreshScope
```

* 配置允许刷新配置的路由

``` yaml
endpoints:
  refresh:
    enabled: true
    sensitive: false
```

### 配置同步动态更新

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

* 配置允许通过MQ刷新配置的路由

``` yaml
endpoints:
  bus:
    enabled: true
    sensitive: false
```

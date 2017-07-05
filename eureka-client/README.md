# eureka-client

演示Eureka Client

|url|desc|  
|:---|:---|   
|http://localhost:8081/swagger-ui.html|Eureka客户端接口列表|  
|http://localhost:8081/health|返回应用程序的健康指标，Actuator提供功能之一|   

## 配置Eureka Client  

* 引入Maven依赖  

``` maven
<!-- eureka　客户端 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
```

* 配置Eureka服务注册地址  

_以下是bootstrap.yml中eureka相关配置_  

``` yml
eureka:
  instance:
    leaseRenewalIntervalInSeconds: 10
    leaseExpirationDurationInSeconds: 30
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
```

_注：增加leaseRenewalIntervalInSeconds和leaseExpirationDurationInSeconds配置，可避免EurekaServer界面以下警告：_  

```
EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.
```

* 启用EurekaClient  

_增加@EnableDiscoveryClient，启用服务注册与发现_  
``` java
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}
```

## 启动Eureka Client  

```bash
mvn spring-boot:run -Dspring.profiles.enable=lo1
mvn spring-boot:run -Dspring.profiles.enable=lo2
```

```bash
java -jar target/eureka-client-1.0.0-SNAPSHOT.jar --spring.profiles.enable=lo1
java -jar target/eureka-client-1.0.0-SNAPSHOT.jar --spring.profiles.enable=lo2
```

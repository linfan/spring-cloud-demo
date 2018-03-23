# HTTP头参数透传插件

## 简介

通过HTTP头透传数据的插件演示，依赖Spring 3.0以后引入的`RestTemplate`类型（Spring Cloud框架默认支持）。

## 使用方法

### 1.基于Spring Boot的应用

采用Spring Boot构建的应用只需加入插件依赖即可，以Maven项目的pom.xml文件为例：

```xml
<dependency>
    <groupId>com.demo.springcloud</groupId>
    <artifactId>transmission-plugin</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

### 2.普通Spring MVC应用

若是使用了Spring MVC，但非Spring Boot的应用，首先引入插件依赖，方法同上。
然后手工增加Bean扫描路径，可通过xml或配置类实现。

xml配置方式：

```xml
<beans>  
    <context:component-scan base-package="com.demo.transmission.plugin"/>  
</beans> 
```

配置类方式:

```java
package <任意包路径>;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.demo.transmission.plugin")
public class TraceConfig {
}
```

## 功能验证

依次启动`eureka-server`,`zipkin-demo`,`eureka-client`,`ribbon-demo`,`feign-demo`服务，
然后访问`feign-demo`服务的`/api/ribbon/trace`接口。例如：

```bash
curl "http://127.0.0.1:8182/api/ribbon/trace?id=123456789"
```

这个请求会将参数`id`的值通过插件透传到`ribbon-demo`和`eureka-client`服务，
最后在`eureka-client`中读取，并返回读取结果。从而证实数据能够沿链路进行传递。

此外，也可以创建大量并发请求，检查不同请求传递数据是否互窜：

```bash
for i in {1..1000}; do
    curl "http://127.0.0.1:8182/api/ribbon/trace?id=$i" >>/tmp/q &
done
```

一阵屏幕乱闪后，检查`/tmp/q`文件内容，请求返回的数值没有重复，从而证实每次数据透传都是独立的。


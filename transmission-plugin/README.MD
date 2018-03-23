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

### 3.普通Spring MVC应用

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

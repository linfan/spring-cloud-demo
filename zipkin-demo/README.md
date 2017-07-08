# Zipkin Demo

服务调用链追踪

## 练习四：服务监控

* 引入Maven依赖  

``` maven
<!-- zipkin -->
<dependency>
    <groupId>io.zipkin.java</groupId>
    <artifactId>zipkin-server</artifactId>
</dependency>
<dependency>
    <groupId>io.zipkin.java</groupId>
    <artifactId>zipkin-autoconfigure-ui</artifactId>
    <scope>runtime</scope>
</dependency>
```

* 启用Zipkin服务端

``` java
@EnableZipkinServer
```

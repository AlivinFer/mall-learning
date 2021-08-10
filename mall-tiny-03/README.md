# SpringBoot 集成 Redis

导入依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
    <version>2.5.3</version>
</dependency>
```

Redis 配置

```yaml
spring:
  redis:
    host: 127.0.0.1 # Redis服务器地址
    port: 6379 # Redis服务器连接端口
    database: 0 # Redis数据库索引（默认为0）
    password: # Redis服务器连接密码（默认为空）
    lettuce:
      pool:
        max-active: 8 # 连接池最大连接数（使用负值表示没有限制）
        max-wait: -1ms # 连接池最大阻塞等待时间（使用负值表示没有限制）
        min-idle: 0 # 连接池中的最小空闲连接
        max-idle: 8 # 连接池中的最大空闲连接
    timeout: 3000ms # 连接超时时间（毫秒）
    
# 自定义redis key
redis:
  key:
    prefix:
      authCode: "portal:authCode:"
    expire:
      authCode: 120 # 验证码超期时间
```

在使用 lettuce 配置 pool 会报下面这个错误：

#### Caused by: java.lang.ClassNotFoundException: org.apache.commons.pool2.impl.GenericObjectPoolConf处理异常

需要导入额外的一个依赖

```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-pool2</artifactId>
    <version>2.0</version>
</dependency>
```

### jedis 和 lettuce 比较

> Jedis

在实现上是直连 redis server，多线程环境下非线程安全，除非使用连接池，为每个 redis实例增加 物理连接，可看成 BIO

> lettuce

是一种可伸缩，线程安全，完全非阻塞的Redis客户端，多个线程可以共享一个RedisConnection,它利用 Netty NIO 框架来高效地管理多个连接，从而提供了异步和同步数据访问方式，用于构建非阻塞的反应性应用程序。




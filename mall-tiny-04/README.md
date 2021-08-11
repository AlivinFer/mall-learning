# SpringBoot 整合 SpringSecurity 和 JWT 实现后台用户的登录和授权功能

### SpringSecurity

> SpringSecurity是一个强大的可高度定制的认证和授权框架，对于Spring应用来说它是一套Web安全标准。SpringSecurity注重于为Java应用提供认证和授权功能，像所有的Spring项目一样，它对自定义需求具有强大的扩展性

### JWT

> JWT是 JSON WEB TOKEN的缩写，它是基于 RFC 7519 标准定义的一种可以安全传输的的JSON对象，由于使用了数字签名，所以是可信任和安全的。

JWT token的格式：header.payload.signature

- header中用于存放签名的生成算法
- payload中用于存放用户名、token的生成时间和过期时间
- signature为以header和payload生成的签名，一旦header和payload被篡改，验证将失败

JWT 字符串可通过在此网站进行解析：https://jwt.io/

#### JWT实现认证和授权的原理

- 用户调用登录接口，登录成功后获取到 JWT 的token；
- 之后用户每次调用接口都在 http 的 header 中添加一个叫 Authorization 的头，值为 JWT 的token；
- 后台程序通过对 Authorization 头中信息的解码及数字签名校验来获取其中的用户信息，从而实现认证和授权

相关依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
    <version>2.5.3</version>
</dependency>
<dependency>
    <groupId>cn.hutool</groupId>
    <artifactId>hutool-all</artifactId>
    <version>5.7.5</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.9.1</version>
</dependency>
<!--导入此依赖可直接在字段上添加参数校验-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
    <version>2.5.2</version>
</dependency>
```




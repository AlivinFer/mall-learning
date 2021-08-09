# Swagger-UI 实现在线 API 文档

> Swagger-UI是HTML, Javascript, CSS的一个集合，可以动态地根据注解生成在线API文档

3.0.0 版本

只需添加下面一个依赖

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```

3.0.0 版本之前需要添加下面两个依赖

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>3.0.0</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>3.0.0</version>
</dependency>
```

## 编写配置文件

```java
@Configuration
// 在3.0.0版本之前为 @EnableSwagger2
@EnableOpenApi
public class Swagger2Config {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3演示")
                .description("mall-tiny")
                .contact(new Contact("alivin", "", "78546123@qq.com"))
                .version("1.0")
                .build();

    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包下controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.alivin.mall.tiny.controller"))
                //为有@Api注解的Controller生成API文档
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //为有@ApiOperation注解的方法生成API文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

}
```

![image-20210809141512597](E:\blog\images\swagger2.png)

上面这些信息均可以根据需求进行修改

## API相关注解

```xml
@Api：用在请求的类上，表示对类的说明
    tags="说明该类的作用，可以在UI界面上看到的注解"

@ApiOperation：用在请求的方法上，说明方法的用途、作用
    value="说明方法的用途、作用"
    notes="方法的备注说明"

@ApiImplicitParams：用在请求的方法上，表示一组参数说明
    @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
        name：参数名
        value：参数的汉字说明、解释
        required：参数是否必须传
        paramType：参数放在哪个地方
            · header --> 请求参数的获取：@RequestHeader
            · query --> 请求参数的获取：@RequestParam
            · path（用于restful接口）--> 请求参数的获取：@PathVariable
            · body（不常用）
            · form（不常用）    
        dataType：参数类型，默认String，其它值dataType="Integer"       
        defaultValue：参数的默认值

@ApiResponses：用在请求的方法上，表示一组响应
    @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
        code：数字，例如400
        message：信息，例如"请求参数没填好"
        response：抛出异常的类

@ApiModel：用于响应类上，表示一个返回响应数据的信息
         （这种一般用在post创建的时候，使用@RequestBody这样的场景，
           请求参数无法使用@ApiImplicitParam注解进行描述的时候）

@ApiModelProperty：用在属性上，描述响应类的属性
				   (可结合 mbg 自动生成)

@ApiParam：用于修饰接口中的参数，生成接口参数相关文档信息
```

## 访问地址

在3.0.0版本之前访问地址为：

http://localhost:8080/swagger-ui.html

3.0.0 版本之后访问地址为：

http://localhost:8080/swagger-ui/index.html

效果：

![image-20210809142829935](E:\blog\images\swagger.png)

## 在在线文档接口上进行测试

![image-20210809144433560](E:\blog\images\swagger3.png)


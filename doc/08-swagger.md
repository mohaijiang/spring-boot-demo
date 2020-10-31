## 1. maven 依赖

```
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```

## 2. 配置swagger
```
/**
 * swagger 配置
 */
@Configuration
@EnableOpenApi
public class Swagger3Config {

    @Bean
    public Docket createRestApi() {
        //返回文档摘要信息
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .apis(RequestHandlerSelectors.withMethodAnnotation(Operation.class))
                .paths(PathSelectors.any())
                .build();
    }

    //生成接口信息，包括标题、联系人等
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3接口文档")
                .description("如有疑问，请联系开发工程师老刘。")
                .contact(new Contact("mohaijiang", "https://github.com/mohaijiang/spring-boot-demo", "haijiang.mo@newtouch.com"))
                .version("1.0")
                .build();
    }

}
```

##3 为接口和模型添加swagger注解
```
@Api:  用来指定一个controller中的各个接口的通用说明
@ApiOption: 说明一个接口方法
@ApiModel:   用于类上面说明功能,
@ApiModelProperty:  用于字段上说明功能
```

##4 访问swagger-ui接口

```
http://localhost:8080/swagger-ui/index.html
```
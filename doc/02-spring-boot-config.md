## spring boot config

1: 导入开发工具 spring-boot-configuration-processor

```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-configuration-processor</artifactId>
  <optional>true</optional>
</dependency>
```

2: idea 启用configuration-processor


## 常用配置方式

Bean配置
```
@Configuration
@ConfigurationProperties(prefix = "xxx")
```

@Value直接读取

```
@Value("${demo.book.name}")
```

## profile
不同环境配置
```
java -jar -Dspring.profiles.active=dev xxx.jar
```


## 配置优先级
```
1. 本地 Devtools 全局配置
2. 测试时 @TestPropertySource 注解配置
3. 测试时 @SpringBootTest 注解的 properties 配置
4. 命令行配置
5. SPRING_APPLICATION_JSON 配置
6. ServletConfig 初始化参数配置
7. ServletContext 初始化参数配置
8. Java 环境的 JNDI 参数配置
9. Java 系统的属性配置
10. OS 环境变量配置
11. 只能随机属性的 RandomValuePropertySource 配置
12. 工程 jar 之外的多环境配置文件（application- {profile}.properties 或 YAML）
13. 工程 jar 之内的多环境配置文件（application- {profile}.properties 或 YAML）
14. 工程 jar 之外的应用配置文件（application.properties 或 YAML）
15. 工程 jar 之内的应用配置文件（application.properties 或 YAML）
16. @Configuration 类中的 @PropertySource 注解配置
17. 默认属性配置（SpringApplication.setDefaultProperties 指定）
```

## 外化配置文件
```
java -jar -Dspring.config.location=D:\config\config.properties springbootrestdemo-0.0.1-SNAPSHOT.jar 
```
## spring-boot-data-jpa

1: 导入依赖jar

```
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <scope>runtime</scope>
</dependency>
```

2: 配置 application.yml

```
spring:
  datasource:
    # 数据库连接信息
    url: jdbc:mysql://ext-a.kubesail.io:42964/demo?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8
    # 数据库用户名
    username: root
    # 数据库密码
    password: 123456
    driver-class-name: com.mysql.cj.jdbc.Driver
    hikari:
      connection-test-query: SELECT 1 FROM DUAL
      connection-timeout: 30000
      maximum-pool-size: 20
      max-lifetime: 1800000
      minimum-idle: 5
  jpa:
    database-platform: org.hibernate.dialect.MySQL5Dialect
    database: MySQL
    openInView: false
    show_sql: true
    generate-ddl: true
    hibernate:
      ddl-auto: update
      naming-strategy: org.hibernate.cfg.DefaultNamingStrategy
    properties:
      hibernate.cache.use_query_cache: false
      hibernate.generate_statistics: false

```


3: 定义 Entity

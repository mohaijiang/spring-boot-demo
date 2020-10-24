## lombok

* 什么是lombok 

    Lombok是一个可以通过简单的注解形式来帮助我们简化消除一些必须有但显得很臃肿的Java代码的工具，通过使用对应的注解，可以在编译源码的时候生成对应的方法

* lombok 使用
    
    1: ide需要安装lombok插件 
    
    2： 项目工程引用maven依赖包
    ```
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <optional>true</optional>
    </dependency>
    ```
  
* lombok 常用注解

    1： get set 方法 
    
    @Getter,@Setter,@Data
    
    2:  构造类方法
    
    @NoArgsConstructor, @RequiredArgsConstructor, @AllArgsConstructor
    
    3： toString 方法
    
    @ToString
    
    4: equals 和 hashcode 方法
    
    @EqualsAndHashCode
    
    5： 构建器
        
    @Builder
    
    6： 同步锁方法
    
    @Synchronized
    
    ```
  import lombok.Synchronized;
  public class SynchronizedExample {
     private final Object readLock = new Object();
     
    @Synchronized
    public static void hello() {
      System.out.println("world");
    }
     
    @Synchronized
    public int answerToLife() {
      return 42;
   }
    @Synchronized("readLock")
    public void foo() {
      System.out.println("bar");
     }
  }
  ```
  
    7: 异常封装
    
    @SneakyThrows
    
    8：自动资源关闭关闭
    
    @Cleanup
    
    9： 日志
    
    @Slf4j
    
package com.newtouch.mohaijiang.springbootdemo.lombok;

import com.newtouch.mohaijiang.springbootdemo.lombok.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Lombok02 {

    @Test
    public void testConstruct(){
        User u1 = new User();

        Assertions.assertEquals(0,u1.getAge());

        User u2 = new User("zhangsan",25);
        Assertions.assertEquals(25,u2.getAge());
    }

    @Test
    public void testBuilder(){
        User u1 = User.builder().name("zhangsan").age(25).build();
        Assertions.assertEquals(25,u1.getAge());
    }


}

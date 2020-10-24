package com.newtouch.mohaijiang.springbootdemo.redis;

import com.newtouch.mohaijiang.springbootdemo.lombok.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;

@SpringBootTest
public class Redis02 {

    @Autowired
    private RedisTemplate<String,?> redisTemplate;

    private static final String KEY = "USER:1";

    @Test
    public void testObject(){

        User u1 = new User("zhangsan",24);
        ValueOperations<String, User> options  = (ValueOperations<String, User>) redisTemplate.opsForValue();
        options.set(KEY,u1);
    }
    @Test
    public void testGet(){
        ValueOperations<String,User> options  = (ValueOperations<String, User>) redisTemplate.opsForValue();
        User u1 = options.get(KEY);
        System.out.println(u1);

        User u2 = options.get("none");
        System.out.println(u2);
    }
}

package com.newtouch.mohaijiang.springbootdemo.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@Slf4j
public class Redis01 {

    private static final String KEY = "HELLo";

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void testGetAndSet(){

        final String VALUE = "你好";
        String value = this.redisTemplate.opsForValue().get(KEY);
        System.out.println(value);

        this.redisTemplate.opsForValue().set(KEY,VALUE);

        Assertions.assertEquals(VALUE,this.redisTemplate.opsForValue().get(KEY));
    }

    @Test
    public void testExpire(){
        // 设置60秒过期
        this.redisTemplate.expire(KEY,60L, TimeUnit.SECONDS);

        // 设置某个时间点过期
        Date date = Date.from(LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant());
        this.redisTemplate.expireAt(KEY,date);

    }

    @Test
    public void deleteKey(){
        this.redisTemplate.delete(KEY);
    }

    @Test
    public void testSetNX(){
        final String nxKey = "NX_KEY_1";
        final String value = Long.toString(System.currentTimeMillis());
        this.redisTemplate.opsForValue().setIfAbsent(nxKey,value,60,TimeUnit.SECONDS);
    }

    public Boolean tryLock(String lockKey,String requestId,long expire,TimeUnit timeUnit){
        try {
            return this.redisTemplate.opsForValue().setIfAbsent(lockKey, requestId, expire, timeUnit);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return false;
        }
    }

    public Boolean releaseLock(String lockKey, String requestId){
        String value = this.redisTemplate.opsForValue().get(lockKey);
        if(value == null){
            return true;
        }else if(value.equals(requestId)){
            return this.redisTemplate.delete(lockKey);
        }else {
            // 锁已经被其他程序占用
            return false;
        }
    }
}

package com.newtouch.mohaijiang.springbootdemo.redis;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;

import java.util.Set;

@SpringBootTest
public class Redis04 {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    private static final String KEY = "set:1";

    private static final String KEY2 = "set:2";

    @Test
    public void testSet(){
        redisTemplate.delete(KEY);
        SetOperations<String, String> ops = redisTemplate.opsForSet();
        Long successCount = ops.add(KEY,"1","1","2");
        Assertions.assertEquals(2,successCount);

        Set<String> sets = ops.members(KEY);
        Assertions.assertEquals(Sets.newHashSet("1","2"),sets);
        // 判断是否在set中
        Assertions.assertFalse(ops.isMember(KEY,"3"));
        Assertions.assertTrue(ops.isMember(KEY,"1"));

        ops.add(KEY2,"1","3");

        // 相交集合
        Set<String> intersect = ops.intersect(KEY, KEY2);
        Assertions.assertEquals(Sets.newHashSet("1"),intersect);

        // 相并集合
        Set<String> unionSet = ops.union(KEY,KEY2);
        Assertions.assertEquals(Sets.newHashSet("1","2","3"),unionSet);

        // 想差的集合
        Set<String> deference = ops.difference(KEY,KEY2);
        Assertions.assertEquals(Sets.newHashSet("2"),deference);
    }
}

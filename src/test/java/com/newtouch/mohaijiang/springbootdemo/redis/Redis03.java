package com.newtouch.mohaijiang.springbootdemo.redis;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class Redis03 {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    private static final String KEY = "list:1";

    private static final String KEY2 = "list:2";

    @Test
    public void testList(){
        // 清空数据，避免影响以下测试
        redisTemplate.delete(KEY);
        BoundListOperations<String, String> ops = redisTemplate.boundListOps(KEY);
        // 列表右边增加
        ops.rightPush("1");

        // 查询列表，注意，start 和 end 可以是负数，详见redis文档
        List<String> list = ops.range(0,100);
        System.out.println(list);
        // 列表左边增加
        ops.leftPush("2");
        // 测试reids内集合数据是否是["2","1"]
        Assertions.assertEquals(Lists.newArrayList("2","1"),ops.range(0,1));

        // 左边push 多个element,数组内结果是什么？
        ops.leftPushAll("4","5");

        Assertions.assertEquals(Lists.newArrayList("5","4","2","1"),ops.range(0,4));

        //列表左侧移除
        String value = ops.leftPop();

        Assertions.assertEquals("5",value);

    }

    /**
     * redis 实现消息队列的关键
     */
    @Test
    public void testReadQueue(){
        BoundListOperations<String, String> ops = redisTemplate.boundListOps(KEY2);
        String value = ops.leftPop(1,TimeUnit.MINUTES);
        System.out.println(value);
    }

    @Test
    public void testInsertQueue(){
        BoundListOperations<String, String> ops = redisTemplate.boundListOps(KEY2);
        ops.rightPush("queue1");
    }


}

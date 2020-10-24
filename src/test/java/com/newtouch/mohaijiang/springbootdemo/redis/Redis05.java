package com.newtouch.mohaijiang.springbootdemo.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

@SpringBootTest
public class Redis05 {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    private static final String KEY = "hash:1";

    @Test
    public void test(){
        this.redisTemplate.delete(KEY);
        ZSetOperations<String, String> ops = this.redisTemplate.opsForZSet();
        ops.add(KEY,"value1",20);
        ops.add(KEY,"value2",21);

        // 根据分数排名
        printZSet(KEY);

        ops.remove(KEY,"value2");

        printZSet(KEY);

        ops.add(KEY,"value2",20);
        //为指定元素加分
        Double score = ops.incrementScore(KEY,"value1",10);
        System.out.println(score);
        printZSet(KEY);

        //返回指定成员的排名（从小到大）
        Long rank  = ops.rank(KEY,"value1");
        ops.reverseRank(KEY,"value1");
        System.out.println(rank);

        //获取分数
        score = ops.score(KEY,"value1");
        System.out.println(score);

        //倒叙获取集合
        printZSet(KEY);
        Set<String> range = ops.reverseRange(KEY,0,-1);
        System.out.println(range);

    }

    private void printZSet(String key) {
        //按照排名先后(从小到大)打印指定区间内的元素, -1为打印全部
        Set<String> range = redisTemplate.opsForZSet().range(key, 0, -1);
        //reverseRange 从大到小
        System.out.println(range);
    }
}

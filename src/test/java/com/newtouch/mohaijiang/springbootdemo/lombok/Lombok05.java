package com.newtouch.mohaijiang.springbootdemo.lombok;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class Lombok05 {

    @Test
    public void testLog(){
        String variables = "你好";
        log.info("我正在进行单元测试,测试内容: {}",variables);
    }
}

package com.newtouch.mohaijiang.springbootdemo.lombok;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Lombok04 {

    @Test

    public void testThrowException(){
        Exception e = Assertions.assertThrows(Exception.class,()->throwIllegalArgumentException());
        Assertions.assertEquals("some args error",e.getMessage());
    }

    @SneakyThrows
    public void throwIllegalArgumentException(){
        throw new Exception("some args error");
    }
}

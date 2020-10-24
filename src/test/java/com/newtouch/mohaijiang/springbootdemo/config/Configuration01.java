package com.newtouch.mohaijiang.springbootdemo.config;

import com.newtouch.mohaijiang.springbootdemo.configuration.OrderConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Configuration01 {

    @Autowired
    private OrderConfiguration orderConfiguration;


    @Test
    public void testConfig(){
        System.out.println(orderConfiguration.getName());
        System.out.println(orderConfiguration.getList());
        System.out.println(orderConfiguration.getMaps());
    }
}

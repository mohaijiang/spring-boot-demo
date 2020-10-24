package com.newtouch.mohaijiang.springbootdemo.lombok;

import com.newtouch.mohaijiang.springbootdemo.model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class Lombok01 {

    @Test
    public void testGetterAndSetter(){
        Order order = new Order();
        order.setId(1L);
        order.setOrderNo("202010240001");
        order.setAmount(new BigDecimal("100.00"));

        Assertions.assertNotNull(order);
        Assertions.assertEquals("202010240001",order.getOrderNo());
    }

    @Test
    public void testToString(){
        Order order = new Order();
        order.setId(1L);
        order.setOrderNo("202010240001");
        order.setAmount(new BigDecimal("100.00"));

        System.out.println(order);
        Assertions.assertTrue(order.toString().contains("202010240001"));
    }
}

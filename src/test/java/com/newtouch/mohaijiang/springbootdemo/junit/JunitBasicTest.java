package com.newtouch.mohaijiang.springbootdemo.junit;

import com.newtouch.mohaijiang.springbootdemo.model.Order;
import com.newtouch.mohaijiang.springbootdemo.model.OrderItem;
import com.newtouch.mohaijiang.springbootdemo.service.OrderService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class JunitBasicTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testAssert(){
        Page<Order> page = this.orderService.queryOrder(0,PageRequest.of(0,10));
        Assertions.assertNotNull(page);
        Assertions.assertEquals(2,page.getContent().size());
        Assertions.assertEquals(2,page.getTotalElements());
        Assertions.assertEquals("20201111100002",page.getContent().get(0).getOrderNo());
    }

    @Test
    public void testNewOrder(){

        BigDecimal amount = new BigDecimal("1000");
        List<OrderItem> items = Lists.newArrayList();
        OrderItem cpu = OrderItem.builder()
                .itemName("RTX2070")
                .amount(new BigDecimal("400"))
                .piece(1)
                .pricePerPiece(new BigDecimal("400"))
                .build();
        OrderItem memory = OrderItem.builder()
                .itemName("8G 3200")
                .amount(new BigDecimal("600"))
                .piece(2)
                .pricePerPiece(new BigDecimal("300"))
                .build();
        items.add(cpu);
        items.add(memory);

        Long id = this.orderService.newOrder(amount,items);
        Assertions.assertNotNull(id);
    }

    @Test
    public void testErrorAmount(){

        BigDecimal amount = new BigDecimal("1200");
        List<OrderItem> items = Lists.newArrayList();
        OrderItem cpu = OrderItem.builder()
                .itemName("RTX2070")
                .amount(new BigDecimal("400"))
                .piece(1)
                .pricePerPiece(new BigDecimal("400"))
                .build();
        OrderItem memory = OrderItem.builder()
                .itemName("8G 3200")
                .amount(new BigDecimal("600"))
                .piece(2)
                .pricePerPiece(new BigDecimal("300"))
                .build();
        items.add(cpu);
        items.add(memory);
        Assertions.assertThrows(IllegalArgumentException.class,() -> this.orderService.newOrder(amount,items));
    }

    @Test
    public void testErrorAmount2(){

        BigDecimal amount = new BigDecimal("-1200");
        List<OrderItem> items = Lists.newArrayList();
        OrderItem cpu = OrderItem.builder()
                .itemName("RTX2070")
                .amount(new BigDecimal("400"))
                .piece(1)
                .pricePerPiece(new BigDecimal("400"))
                .build();
        OrderItem memory = OrderItem.builder()
                .itemName("8G 3200")
                .amount(new BigDecimal("600"))
                .piece(2)
                .pricePerPiece(new BigDecimal("300"))
                .build();
        items.add(cpu);
        items.add(memory);
        Assertions.assertThrows(IllegalArgumentException.class,() -> this.orderService.newOrder(amount,items));
    }

    @Test
    public void testErrorItem(){

        BigDecimal amount = new BigDecimal("1200");
        List<OrderItem> items = Lists.newArrayList();
        Assertions.assertThrows(IllegalArgumentException.class,() -> this.orderService.newOrder(amount,items));
    }
}

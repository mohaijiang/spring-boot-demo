package com.newtouch.mohaijiang.springbootdemo.junit;

import com.mysql.cj.jdbc.exceptions.MySQLTimeoutException;
import com.newtouch.mohaijiang.springbootdemo.model.Order;
import com.newtouch.mohaijiang.springbootdemo.model.OrderItem;
import com.newtouch.mohaijiang.springbootdemo.repository.OrderRepository;
import com.newtouch.mohaijiang.springbootdemo.service.OrderService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class JunitMockTest {

    @MockBean
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @Test
    public void testOrder(){

        Order mockOrder = new Order();
        mockOrder.setOrderNo("202101010001");
        Mockito.when(orderRepository.findTopByOrderByOrderNoDesc()).thenReturn(mockOrder);
        Mockito.when(orderRepository.save(Mockito.any())).thenAnswer(a -> {
            Order input = a.getArgument(0);
            input.setId(100L);
            return input;
        });
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
        Assertions.assertEquals(100L,id);
    }

    @Test
    public void testMockThrow(){
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

        Mockito.when(this.orderRepository.findTopByOrderByOrderNoDesc()).thenThrow(new RuntimeException());

        Assertions.assertThrows(RuntimeException.class,()->{
            this.orderService.newOrder(amount,items);
        });
    }
}

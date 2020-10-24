package com.newtouch.mohaijiang.springbootdemo.jpa;

import com.newtouch.mohaijiang.springbootdemo.model.Order;
import com.newtouch.mohaijiang.springbootdemo.model.OrderItem;
import com.newtouch.mohaijiang.springbootdemo.repository.OrderRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@SpringBootTest
public class OrderTest {

    @Autowired
    private EntityManager em;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional
    public void testSave1(){
        Order order = this.newOrder();
        this.em.persist(order);
    }

    @Test
    @Transactional
    public void testSave2(){
        Order order = this.newOrder();
        this.orderRepository.save(order);
    }

    private Order newOrder(){
        Order order = new Order();
        order.setOrderNo("202010250001");
        order.setAmount(new BigDecimal("1000"));
        order.setStatus(0);

        OrderItem item = new OrderItem();
        item.setPiece(2);
        item.setPricePerPiece(new BigDecimal("500"));
        item.setItemName("某个商品名");
        item.setOrder(order);
        item.setAmount(new BigDecimal("1000"));

        order.setItems(Lists.newArrayList(item));
        return order;
    }
}

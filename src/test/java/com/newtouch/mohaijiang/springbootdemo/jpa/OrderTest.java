package com.newtouch.mohaijiang.springbootdemo.jpa;

import com.google.common.collect.Lists;
import com.newtouch.mohaijiang.springbootdemo.model.Order;
import com.newtouch.mohaijiang.springbootdemo.model.OrderItem;
import com.newtouch.mohaijiang.springbootdemo.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

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

        Order dbEntity = this.em.find(Order.class,1L);

        // update
        order.setStatus(2);
        this.em.merge(order);
        // delete
//        this.em.remove(order);

        Query query = this.em.createQuery("from Order where orderNo = :orderNo");
//        this.em.createNativeQuery("");
        query.setParameter("orderNo","202010250001");
        List<Order> orders = query.getResultList();
        System.out.println(orders);
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

    @Test
    public void testPage(){
        Pageable pageable = PageRequest.of(0,10);
        Page<Order> page = orderRepository.findByStatus(0,pageable);
        System.out.println(page.getContent());
    }

}

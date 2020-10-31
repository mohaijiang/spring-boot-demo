package com.newtouch.mohaijiang.springbootdemo.service;

import com.newtouch.mohaijiang.springbootdemo.model.Order;
import com.newtouch.mohaijiang.springbootdemo.model.OrderItem;
import com.newtouch.mohaijiang.springbootdemo.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
//@Service
//@Transactional(rollbackOn = Exception.class)
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public Page<Order> queryOrder(Integer status, Pageable pageable){
        return this.orderRepository.findByStatusOrderByOrderNoDesc(0,pageable);
    }

    public Long newOrder(BigDecimal amount, List<OrderItem> items){
        if(amount == null || amount.compareTo(BigDecimal.ZERO)< 0 ){
            throw new IllegalArgumentException("金额不能小于0");
        }
        if(items == null || items.size() <= 0 ){
            throw new IllegalArgumentException("子订单项不能为空");
        }

        BigDecimal itemAmount = items.stream().map(OrderItem::getAmount).reduce(BigDecimal.ZERO,BigDecimal::add);
        if(!itemAmount.equals(amount)){
            throw new IllegalArgumentException("子订单金额与主订单金额不匹配");
        }

        Order order = new Order();
        order.setStatus(0);
        String lastOrderNo = this.orderRepository.findTopByOrderByOrderNoDesc().getOrderNo();
        order.setOrderNo(Long.toString(Long.valueOf(lastOrderNo) + 1L));
        order.setAmount(amount);
        order.setItems(items);

        items.forEach(t -> t.setOrder(order));
        this.orderRepository.save(order);
        return order.getId();
    }
}

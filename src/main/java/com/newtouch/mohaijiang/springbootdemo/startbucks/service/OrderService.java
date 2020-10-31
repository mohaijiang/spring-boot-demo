package com.newtouch.mohaijiang.springbootdemo.startbucks.service;

import com.google.common.collect.Lists;
import com.newtouch.mohaijiang.springbootdemo.startbucks.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private Map<Integer, Order> map = new HashMap<>();

    private AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * 下单
     * @param order
     */
    public Integer newOrder(Order order) {
        order.setId(atomicInteger.getAndIncrement());
        int cost = calculateCost(order);
        order.setCost(cost);
        order.setPayStatus(false);
        order.setMakeStatus("0");
        this.map.put(order.getId(),order);
        return order.getId();
    }

    /**
     * 根据单号获取订单信息
     * @param id
     * @return
     */
    public Order getOrderById(Integer id){
        return this.map.get(id);
    }

    /**
     * 变更咖啡内容
     * @param orderId
     * @param order
     */
    public void modifyOrder(Integer orderId,Order order){
        Order source = this.map.get(orderId);
        if(!source.getMakeStatus().equals("0")){
            throw new RuntimeException("太晚了，咖啡已经开始制作");
        }
        if(!source.getDrank().equals(order.getDrank())){
            source.setDrank(order.getDrank());
            this.calculateCost(source);
        }

        if(source.getAdditions() != null && !source.getAdditions().equals(order.getAdditions())){
            source.setAdditions(order.getAdditions());
            this.calculateCost(source);
        }
        // 修改制作状态
        if(!StringUtils.isEmpty(order.getMakeStatus())){
            source.setMakeStatus(order.getMakeStatus());
        }

        this.map.put(source.getId(),source);
    }

    /**
     * 删除订单
     * @param orderId
     */
    public void deleteOrder(Integer orderId){
        this.map.remove(orderId);
    }
    private Integer calculateCost(Order order){
        int cost = 0;
        if("摩卡".equals(order.getDrank())){
            cost += 20;
        }else if("美式".equals(order.getDrank())){
            cost +=25;
        }

        if("牛奶".equals(order.getAdditions())){
            cost += 8;
        }else if ("可可".equals(order.getAdditions())){
            cost += 10;
        }
        return cost;
    }

    /**
     * 查询订单
     * @param makeStatus
     * @return
     */
    public List<Order> queryOrder(String makeStatus) {
        if(StringUtils.isEmpty(makeStatus)){
            return Lists.newArrayList(this.map.values());
        }

        return this.map.values().stream().filter(t -> t.getMakeStatus().equals(makeStatus)).collect(Collectors.toList());
    }

    /**
     * 支付订单
     * @param orderId
     * @param order
     */
    public void payOrder(Integer orderId, Order order) {
        Order source = this.map.get(orderId);

        if(source.getCost().equals(order.getCost())){
            source.setPayStatus(true);
            this.map.put(source.getId(),source);
        }else{
            throw new RuntimeException("支付金额不正确");
        }
    }


}

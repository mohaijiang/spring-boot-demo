package com.newtouch.mohaijiang.springbootdemo.startbucks.controller;

import com.newtouch.mohaijiang.springbootdemo.startbucks.entity.Order;
import com.newtouch.mohaijiang.springbootdemo.startbucks.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 星巴克 order
 */
@RestController
@RequestMapping("/v1/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    /**
     * 下单
     * @param order
     * @return
     */
    @PostMapping
    public Integer order(@RequestBody Order order){
        return this.orderService.newOrder(order);
    }

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    @GetMapping(value = "/{orderId}")
    public Order getOrderDetail(@PathVariable Integer orderId){
        return this.orderService.getOrderById(orderId);
    }

    /**
     * 删除订单
     * @param orderId
     */
    @DeleteMapping(value = "/{orderId}")
    public void deleteOrder(@PathVariable Integer orderId){
        this.orderService.deleteOrder(orderId);
    }

    /**
     * 修改订单
     * @param orderId
     */
    @PutMapping(value = "/{orderId}")
    public void modifyOrder(@PathVariable Integer orderId,@RequestBody Order order){
        this.orderService.modifyOrder(orderId,order);
    }
}

package com.newtouch.mohaijiang.springbootdemo.startbucks.controller;

import com.newtouch.mohaijiang.springbootdemo.startbucks.entity.Order;
import com.newtouch.mohaijiang.springbootdemo.startbucks.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/v1/payment/order")
public class PaymentOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/{orderId}")
    public Order getPaymentInfo(@PathVariable Integer orderId){
        return this.orderService.getOrderById(orderId);
    }

    @PutMapping(value = "/{orderId}")
    public void paymentOrder(@PathVariable Integer orderId,@RequestBody Order order){
        this.orderService.payOrder(orderId,order);
    }
}


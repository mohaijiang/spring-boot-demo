package com.newtouch.mohaijiang.springbootdemo.startbucks.controller;

import com.newtouch.mohaijiang.springbootdemo.startbucks.entity.Order;
import com.newtouch.mohaijiang.springbootdemo.startbucks.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/orders")
@RestController
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> dealOrders(@RequestParam String makeStatus){
        return this.orderService.queryOrder(makeStatus);
    }
}

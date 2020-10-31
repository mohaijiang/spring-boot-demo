package com.newtouch.mohaijiang.springbootdemo.startbucks.controller;

import com.newtouch.mohaijiang.springbootdemo.startbucks.entity.Order;
import com.newtouch.mohaijiang.springbootdemo.startbucks.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "订单")
@RequestMapping("/orders")
@RestController
public class OrdersController {

    @Autowired
    private OrderService orderService;


    @ApiOperation(value = "查询订单列表")
    @GetMapping
    public List<Order> queryOrders(@RequestParam String makeStatus){
        return this.orderService.queryOrder(makeStatus);
    }
}

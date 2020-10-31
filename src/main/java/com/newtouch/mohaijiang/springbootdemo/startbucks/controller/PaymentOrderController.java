package com.newtouch.mohaijiang.springbootdemo.startbucks.controller;

import com.newtouch.mohaijiang.springbootdemo.startbucks.entity.Order;
import com.newtouch.mohaijiang.springbootdemo.startbucks.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "订单支付")
@RequestMapping(value = "/v1/payment/order")
@RestController
public class PaymentOrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "获取订单支付信息")
    @GetMapping(value = "/{orderId}")
    public Order getPaymentInfo(@PathVariable Integer orderId){
        return this.orderService.getOrderById(orderId);
    }

    @ApiOperation(value = "进行订单支付")
    @PutMapping(value = "/{orderId}")
    public void paymentOrder(@PathVariable Integer orderId,@RequestBody Order order){
        this.orderService.payOrder(orderId,order);
    }
}


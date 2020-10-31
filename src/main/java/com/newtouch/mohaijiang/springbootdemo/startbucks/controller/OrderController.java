package com.newtouch.mohaijiang.springbootdemo.startbucks.controller;

import com.newtouch.mohaijiang.springbootdemo.startbucks.entity.Order;
import com.newtouch.mohaijiang.springbootdemo.startbucks.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 星巴克 order
 */
@Api(tags = "订单")
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
    @ApiOperation("下单")
    @PostMapping
    public Integer order(@RequestBody Order order){
        return this.orderService.newOrder(order);
    }

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    @ApiOperation(value = "查询订单详情")
    @GetMapping(value = "/{orderId}")
    public Order getOrderDetail(@PathVariable Integer orderId){
        return this.orderService.getOrderById(orderId);
    }

    /**
     * 删除订单
     * @param orderId
     */
    @ApiOperation(value = "删除订单")
    @DeleteMapping(value = "/{orderId}")
    public void deleteOrder(@PathVariable Integer orderId){
        this.orderService.deleteOrder(orderId);
    }

    /**
     * 修改订单
     * @param orderId
     */
    @ApiOperation(value = "修改订单")
    @PutMapping(value = "/{orderId}")
    public void modifyOrder(@PathVariable Integer orderId,@RequestBody Order order){
        this.orderService.modifyOrder(orderId,order);
    }
}

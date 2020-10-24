package com.newtouch.mohaijiang.springbootdemo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单对象
 * @author mohaijiang
 */
@Data
@EqualsAndHashCode
@ToString
public class Order {

    /**
     * id
     */
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 实付金额
     */
    private BigDecimal amount;

    /**
     * 订单子项
     */
    private List<OrderItem> items;
}

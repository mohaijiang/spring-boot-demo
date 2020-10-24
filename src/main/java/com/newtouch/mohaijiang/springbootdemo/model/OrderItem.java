package com.newtouch.mohaijiang.springbootdemo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 子订单内容
 */
@Data
@EqualsAndHashCode(exclude = {"order"})
@ToString(exclude = {"order"})
public class OrderItem {

    /**
     *  id
     */
    private Long id;

    /**
     * 主订单
     */
    private Order order;

    /**
     *  购买物品名称
     */
    private String itemName;

    /**
     * 每件价格
     */
    private BigDecimal pricePerPiece;

    /**
     * 购买件数
     */
    private Integer piece;

    /**
     * 总价
     */
    private BigDecimal amount;

}

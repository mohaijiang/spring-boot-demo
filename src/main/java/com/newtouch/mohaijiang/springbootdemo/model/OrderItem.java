package com.newtouch.mohaijiang.springbootdemo.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 子订单内容
 */
@Data
@EqualsAndHashCode(exclude = {"order"})
@ToString(exclude = {"order"})
@Entity
@Table(name="t_order_item")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {

    /**
     *  id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 主订单
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    /**
     *  购买物品名称
     */
    @Column(name = "item_name",nullable = false)
    private String itemName;

    /**
     * 每件价格
     */
    @Column(name = "price_per_piece",nullable = false)
    private BigDecimal pricePerPiece;

    /**
     * 购买件数
     */
    @Column(name = "piece",nullable = false)
    private Integer piece;

    /**
     * 总价
     */
    @Column(nullable = false)
    private BigDecimal amount;

}

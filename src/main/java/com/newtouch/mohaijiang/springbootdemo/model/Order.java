package com.newtouch.mohaijiang.springbootdemo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * 订单对象
 * @author mohaijiang
 */
@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name="t_order")
public class Order {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 订单号
     */
    @Column(name = "order_no",nullable = false)
    private String orderNo;

    /**
     * 订单状态
     */
    @Column(name = "status",nullable = false)
    private Integer status;

    /**
     * 实付金额
     */
    @Column(name = "amount",nullable = false)
    private BigDecimal amount;

    /**
     * 订单子项
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    private List<OrderItem> items;
}

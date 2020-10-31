package com.newtouch.mohaijiang.springbootdemo.startbucks.entity;

import lombok.Data;

/**
 * 星巴克 订单
 */
@Data
public class Order {

    private Integer id;
    /**
     * 饮品
     */
    private String drank;

    /**
     *  额外配料，如牛奶等
     */
    private String additions;

    /**
     * 花费
     */
    private Integer cost;

    /**
     * 支付状态
     */
    private boolean payStatus;

    /**
     * 制作状态 0，未制作，1：制作中，2： 制作完成
     */
    private String makeStatus;


}

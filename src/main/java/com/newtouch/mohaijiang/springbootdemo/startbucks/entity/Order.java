package com.newtouch.mohaijiang.springbootdemo.startbucks.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 星巴克 订单
 */
@Data
@ApiModel(value = "星巴克 订单")
public class Order {

    @ApiModelProperty(value = "订单号")
    private Integer id;
    /**
     * 饮品
     */
    @ApiModelProperty(value = "饮品")
    private String drank;

    /**
     *  额外配料，如牛奶等
     */
    @ApiModelProperty(value = "配料",allowableValues = "牛奶,可可")
    private String additions;

    /**
     * 花费
     */
    @ApiModelProperty(value = "订单金额")
    private Integer cost;

    /**
     * 支付状态
     */
    @ApiModelProperty(value = "支付状态")
    private boolean payStatus;

    /**
     * 制作状态 0，未制作，1：制作中，2： 制作完成
     */
    @ApiModelProperty(value = "制作状态 0，未制作，1：制作中，2： 制作完成",allowableValues = "1,2,3")
    private String makeStatus;


}

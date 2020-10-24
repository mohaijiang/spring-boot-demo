package com.newtouch.mohaijiang.springbootdemo.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * 订单一些配置
 * @author mohaijiang
 */
@Configuration
@ConfigurationProperties(prefix = "order")
@Data
public class OrderConfiguration {

    private String name;
    private Map<String,String> maps;
    private List<String> list;

}

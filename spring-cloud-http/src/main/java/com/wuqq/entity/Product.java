package com.wuqq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: wuqq
 * @date: 2021/7/31 8:13 PM
 * @version: 1.0
 */

@Data
@AllArgsConstructor
public class Product {

    private Long id;
    private Integer num;
    private BigDecimal price;
    private String name;
    private String category;

}

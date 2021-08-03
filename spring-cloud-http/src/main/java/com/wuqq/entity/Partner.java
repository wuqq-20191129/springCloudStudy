package com.wuqq.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: wuqq
 * @date: 2021/8/1 4:27 PM
 * @version: 1.0
 */
@Data
@NoArgsConstructor
public class Partner {
    private Integer partnerId;

    private List<String> skpCodes;
}

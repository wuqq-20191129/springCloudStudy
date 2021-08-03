package com.wuqq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: wuqq
 * @date: 2021/8/1 4:01 PM
 * @version: 1.0
 */
@Data
@NoArgsConstructor
public class TestEntity {

    private Integer taskId;

    private List<Partner> partnerList;


}

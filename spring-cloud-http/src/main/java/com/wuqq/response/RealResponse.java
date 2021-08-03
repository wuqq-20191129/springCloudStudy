package com.wuqq.response;

import lombok.Data;

import java.util.List;

/**
 * @author: wuqq
 * @date: 2021/8/2 10:39 PM
 * @version: 1.0
 */
@Data
public class RealResponse {

    private String code;
    private String message;
    private List<DataFromHttp> data;
}

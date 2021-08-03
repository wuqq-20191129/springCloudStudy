package com.wuqq.response;

import lombok.Data;

import java.util.List;

/**
 * @author: wuqq
 * @date: 2021/8/2 10:41 PM
 * @version: 1.0
 */
@Data
public class DataFromHttp {
    private String taskId;
    private String clientId;
    private List<InvoiceInfo> success;
    private List<InvoiceInfo> error;
}

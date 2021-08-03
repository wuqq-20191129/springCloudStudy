package com.wuqq.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author: wuqq
 * @date: 2021/8/2 10:43 PM
 * @version: 1.0
 */
@Data
public class InvoiceInfo {
    private String sheetId;
    private String invoiceType;
    private List<String> invoiceNumber;
}

package com.wuqq.consumer.entry;

//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.experimental.Accessors;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuqq
 * @since 2021-05-19
 */
//@Data
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
public class OrderTest implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer orderId;

    private String username;

    private String content;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

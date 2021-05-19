package com.wuqq.rocket.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.experimental.Accessors;

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
@TableName("ORDER_TEST")
public class OrderTest implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ORDER_ID")
    private BigDecimal orderId;

    @TableField("USER_NAME")
    private String userName;

    public BigDecimal getOrderId() {
        return orderId;
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @TableField("CONTENT")
    private String content;



}

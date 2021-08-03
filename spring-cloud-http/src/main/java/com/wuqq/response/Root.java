package com.wuqq.response;

/**
 * @author: wuqq
 * @date: 2021/8/2 9:47 PM
 * @version: 1.0
 */

import java.util.List;
public class Root{
    private List<Order> orders;

    public void setOrders(List<Order> orders){
        this.orders = orders;
    }
    public List<Order> getOrders(){
        return this.orders;
    }
}

package com.wuqq.rocket.controller;


import com.wuqq.rocket.Impl.OrderTestServiceImpl;
import com.wuqq.rocket.entity.OrderTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuqq
 * @since 2021-05-19
 */
@RestController
@RequestMapping("/rocket/order-test")
public class OrderTestController {

    private Logger logger = LoggerFactory.getLogger(OrderTestController.class);

    @Autowired
    private OrderTestServiceImpl orderTestService;

    @GetMapping("/createOrder")
    public void createOrder(int id , String userName, String content){
//        logger.info("接收订单数据={}",id,userName,content);
        logger.info("id={}",id);
        logger.info("userName={}",userName);

        logger.info("content={}",content);

        OrderTest orderTest = new OrderTest();
        orderTest.setOrderId(id);
        orderTest.setUsername(userName);
        orderTest.setContent(content);
        orderTestService.save(orderTest);
    }

}

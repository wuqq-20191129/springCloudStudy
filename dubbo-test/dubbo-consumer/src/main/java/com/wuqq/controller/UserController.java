package com.wuqq.controller;

import com.wuqq.entity.User;
import com.wuqq.service.ConsumerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2021/4/30 10:53
 * @Created by mh
 */

@RestController
public class UserController {

    @Resource
    private ConsumerService consumerService;

    @RequestMapping("/getParam")
    public String getParam(){
        return consumerService.getInfo("wuqq");
    }

    @RequestMapping("/getUserInfo")
    public User getUser(){
        User user =new User();
        user.setId(12345);
        user.setName("wuqq");

        return  consumerService.getUserInfo(user);
    }
}

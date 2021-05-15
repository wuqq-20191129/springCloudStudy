package com.wuqq.service;

import com.alibaba.dubbo.config.annotation.Reference;

import com.wuqq.entity.User;
import org.springframework.stereotype.Service;

/**
 * @Classname ConsumerService
 * @Description TODO
 * @Date 2021/4/30 10:48
 * @Created by mh
 */
@Service
public class ConsumerService implements UserService{

    @Reference
    private UserService userService;

    @Override
    public String getInfo(String param) {
        return userService.getInfo(param);
    }

    @Override
    public User getUserInfo(User user) {
        return userService.getUserInfo(user);
    }

    @Override
    public String timeOut(int time) {
        return userService.timeOut(time);
    }

}

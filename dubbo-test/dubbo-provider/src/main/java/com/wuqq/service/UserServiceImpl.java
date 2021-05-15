package com.wuqq.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wuqq.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2021/4/30 10:39
 * @Created by mh
 */

@Service(timeout = 3000)
@Component
public class UserServiceImpl implements  UserService{

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public String getInfo(String param) {
        logger.info("字符参数：{}",param);
        return "hello from consumer";
    }

    @Override
    public User getUserInfo(User user) {
        logger.info("实体类参数：{}",user);
        return user;
    }

    @Override
    public String timeOut(int time) {
        logger.info("超时测试{}",time);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "超时了";
        }
        return "success";
    }
}

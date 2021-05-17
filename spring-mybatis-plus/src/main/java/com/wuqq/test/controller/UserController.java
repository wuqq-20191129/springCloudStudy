package com.wuqq.test.controller;


import com.wuqq.test.entity.User;
import com.wuqq.test.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuqq
 * @since 2021-05-17
 */
@RestController
@RequestMapping("/test/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private IUserService iUserService;


    @RequestMapping("/getUser")
    public void getUser(){
        List<User> list = iUserService.list();
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            logger.info("",((User)iterator.next()).toString());
        }
    }

}

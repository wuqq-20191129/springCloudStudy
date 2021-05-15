package com.wuqq.mongodb.controller;

import com.wuqq.mongodb.entry.User;
import com.wuqq.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2021/5/13 10:15
 * @Created by mh
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("/add")
    public String add(){
        User user = new User();
        user.setId(1);
        user.setAge("20");
        user.setName("wuqq");

        try {
            userService.add(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping("/find")
    public List<User> findAll(){
        List list = new ArrayList<User>();
        try {
            list = userService.find();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

package com.wuqq.mongodb.service.Impl;

import com.wuqq.mongodb.dao.UserDao;
import com.wuqq.mongodb.entry.User;
import com.wuqq.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2021/5/13 10:09
 * @Created by mh
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao dao;

    @Override
    public String add(User user) {
        try {
            dao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    @Override
    public List find() {
        List<User> list = new ArrayList<>();
        try {
             list = dao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

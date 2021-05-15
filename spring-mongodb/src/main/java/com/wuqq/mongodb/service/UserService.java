package com.wuqq.mongodb.service;

import com.wuqq.mongodb.entry.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2021/5/13 10:03
 * @Created by mh
 */

public interface UserService {
    /**
     *
     * @Description TODO
     * @Param
     * @param 查询
     * @Return
     * @Date    2021/5/13 10:08
     * @Created by ${USER}
     */
    public String add(User user);

    public List find();
}

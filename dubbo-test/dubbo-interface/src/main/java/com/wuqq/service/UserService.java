package com.wuqq.service;

import com.wuqq.entity.User;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2021/4/30 9:57
 * @Created by mh
 */
public interface UserService {

    String getInfo(String param);

    User getUserInfo(User user);

    String timeOut(int time );
}

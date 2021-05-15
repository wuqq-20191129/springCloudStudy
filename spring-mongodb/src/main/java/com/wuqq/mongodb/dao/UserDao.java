package com.wuqq.mongodb.dao;

import com.wuqq.mongodb.entry.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2021/5/13 9:59
 * @Created by mh
 */
public interface UserDao extends MongoRepository<User,Integer> {
}

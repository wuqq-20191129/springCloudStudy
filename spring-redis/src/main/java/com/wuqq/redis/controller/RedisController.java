package com.wuqq.redis.controller;

import com.wuqq.redis.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: wuqq
 * @date: 2021/5/15 11:26 PM
 * @version: 1.0
 */

@RestController
public class RedisController {

    private static Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Resource
    RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("/set")
    public boolean set(String key,String value){
        logger.info("访问set:key={},value={}",key,value);
        try {
            RedisUtil.set(this.redisTemplate,key,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping("/get")
    public String get(String key){
        logger.info("访问get:key={}",key);
        try {
            String value = (String)RedisUtil.get(this.redisTemplate,key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

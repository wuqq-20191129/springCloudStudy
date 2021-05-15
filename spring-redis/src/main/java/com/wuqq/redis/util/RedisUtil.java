package com.wuqq.redis.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: wuqq
 * @date: 2021/5/15 6:30 PM
 * @version: 1.0
 */

public class RedisUtil {

    /**
     *
     * @description: 指定过期时间
     * @return:
     * @author: niaonao
     * @date: 2021/5/15
     */
    public static boolean expire(RedisTemplate<String,Object> redisTemplate,String key,long time){
        try {
            if(time>0){
                redisTemplate.expire(key,time, TimeUnit.MILLISECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     *
     * @description: 根据key 获取过期时间
     * @return:
     * @author: niaonao
     * @date: 2021/5/15
     */
    public static long getExpire(RedisTemplate<String,Object> redisTemplate,String key){
        return redisTemplate.getExpire(key);
    }

    /**
     *
     * @description: 判断key 是否存在
     * @return:
     * @author: niaonao
     * @date: 2021/5/15
     */
    public static boolean hasKey(RedisTemplate<String,Object> redisTemplate,String key){
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @description: 删除 缓存
     * @return:
     * @author: niaonao
     * @date: 2021/5/15
     */
    public static void del(RedisTemplate<String,Object> redisTemplate,String... key){
        if(key !=null || key.length>0){
            if(key.length==1){
                redisTemplate.delete(key[0]);
            }else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    //    ================================String======================
    /**
     *
     * @description: String类型 获取
     * @return:
     * @author: niaonao
     * @date: 2021/5/15
     */
    public static Object get(RedisTemplate<String,Object> redisTemplate, String  key){
        return key==null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     *
     * @description: 普通类型放入缓存
     * @return:
     * @author: niaonao
     * @date: 2021/5/15
     */
    public static boolean set(RedisTemplate<String,Object> redisTemplate,String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @description: 放入缓存 并设置过期时间 time<0 则设置无限期
     * @return:
     * @author: niaonao
     * @date: 2021/5/15
     */
    public static boolean set(RedisTemplate<String,Object> redisTemplate,String key,Object value,long time){
        try {
            if(time>0){
                redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
            }else {
                //redisTemplate.opsForValue().set(key,value);
                //回调
                set(redisTemplate, key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     *
     * @description: 递增
     * @return:
     * @author: niaonao
     * @date: 2021/5/15
     */
    public static long incr(RedisTemplate<String,Object> redisTemplate,String key,long inc){
        if(inc<0){
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key,inc);
    }
    /**
     *
     * @description: 递减(<0)
     * @return:
     * @author: niaonao
     * @date: 2021/5/15
     */
    public static long desc(RedisTemplate<String,Object> redisTemplate,String key,long desc){
        if(desc<0){
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().decrement(key,-desc);
    }

//    ==========================Map=======================================
    /**
     *
     * @description: HashGet key不能为null value不能为null
     * @return:
     * @author: niaonao
     * @date: 2021/5/15
     */
    public static Object hget(RedisTemplate<String,Object> redisTemplate,String key, String item){
        return redisTemplate.opsForHash().get(key,item);
    }

    /**
     *
     * @description: 获取所有键值  多个键值对 为map
     * @return:
     * @author: niaonao
     * @date: 2021/5/15
     */
    public static Map<Object,Object> hmget(RedisTemplate<String,Object> redisTemplate,String key){
        return redisTemplate.opsForHash().entries(key);
    }


}

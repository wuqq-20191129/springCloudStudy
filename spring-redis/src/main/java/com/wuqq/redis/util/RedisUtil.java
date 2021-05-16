package com.wuqq.redis.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
     * @return:         key 不能为null
     * @author: niaonao
     * @date: 2021/5/15
     */
    public static Map<Object,Object> hmget(RedisTemplate<String,Object> redisTemplate,String key){
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     *
     * @description: HashSet 设置键值对
     * @return:
     * @author: niaonao
     * @date: 2021/5/16
     */
    public static boolean hmset(RedisTemplate<String ,Object> redisTemplate,String key,Map<Object,Object> map){
        try {
            redisTemplate.opsForHash().putAll(key,map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     *
     * @description: HashSet 并设置缓存时间
     * @return:
     * @author: niaonao
     * @date: 2021/5/16
     */
    public static  boolean hmset(RedisTemplate<String ,Object> redisTemplate,String key,Map<Object,Object> map,long time){
        try {
            redisTemplate.opsForHash().putAll(key,map);
            if(time>0){
                expire(redisTemplate,key,time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     *
     * @description: 向一张hash表中放入数据，若不存在 则创建
     * @return:
     * @author: niaonao
     * @date: 2021/5/16
     */
    public static boolean hset(RedisTemplate<String,Object> redisTemplate,String key ,String item,Object value){
        try {
            redisTemplate.opsForHash().put(key,item,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     *
     * @description: 向一张hash表中放入数据，若不存在 则创建 并指定缓存时间
     * @return:
     * @author: niaonao
     * @date: 2021/5/16
     */
    public static boolean hset(RedisTemplate<String,Object> redisTemplate,String key,String item,Object value,long time){
        try {
            redisTemplate.opsForHash().put(key,item,value);
            if(time>0){
                expire(redisTemplate,key,time);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     *
     * @description: 删除hash表中数据
     * @return:
     * @author: niaonao
     * @date: 2021/5/16
     */

    public static void del(RedisTemplate<String,Object> redisTemplate,String key,Object... item){
        redisTemplate.opsForHash().delete(key,item);
    }

    /**
     *
     * @description: 判断hash表是否有该项的值
     * @return:
     * @author: niaonao
     * @date: 2021/5/16
     */
    public static boolean hHasKey(RedisTemplate<String,Object> redisTemplate,String key,String item){
        return redisTemplate.opsForHash().hasKey(key,item);
    }
    /**
     *
     * @description: hash递增，如果不存在 则创建 并返回新增的值
     * @return:
     * @author: niaonao
     * @date: 2021/5/16
     */
    public static double hincr(RedisTemplate<String,Object> redisTemplate,String key,String item,double by){
        return redisTemplate.opsForHash().increment(key,item,by);
    }
    /**
     *
     * @description: hash递减
     * @return:
     * @author: niaonao
     * @date: 2021/5/16
     */
    public static double hdecr(RedisTemplate<String,Object> redisTemplate,String key,String item,double by){
        return redisTemplate.opsForHash().increment(key,item,-by);
    }

    // ============================set=============================

    /**
     * 根据key获取Set中的所有值
     *
     * @param key 键
     * @return
     */
    public static Set<Object> sGet(RedisTemplate<String, Object> redisTemplate, String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据value从一个set中查询,是否存在
     *
     * @param key   键
     * @param value 值
     * @return true 存在 false不存在
     */
    public static boolean sHasKey(RedisTemplate<String, Object> redisTemplate, String key, Object value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将数据放入set缓存
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public static long sSet(RedisTemplate<String, Object> redisTemplate, String key, Object... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 将set数据放入缓存
     *
     * @param key    键
     * @param time   时间(秒)
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public static long sSetAndTime(RedisTemplate<String, Object> redisTemplate, String key, long time,
                                   Object... values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0)
                expire(redisTemplate, key, time);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取set缓存的长度
     *
     * @param key 键
     * @return
     */
    public static long sGetSetSize(RedisTemplate<String, Object> redisTemplate, String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 移除值为value的
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    public static long setRemove(RedisTemplate<String, Object> redisTemplate, String key, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().remove(key, values);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    // ===============================list=================================

    /**
     * 获取list缓存的内容
     *
     * @param key   键
     * @param start 开始
     * @param end   结束 0 到 -1代表所有值
     * @return
     */
    public static List<Object> lGet(RedisTemplate<String, Object> redisTemplate, String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取list缓存的长度
     *
     * @param key 键
     * @return
     */
    public static long lGetListSize(RedisTemplate<String, Object> redisTemplate, String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 通过索引 获取list中的值
     *
     * @param key   键
     * @param index 索引 index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    public static Object lGetIndex(RedisTemplate<String, Object> redisTemplate, String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public static boolean lSet(RedisTemplate<String, Object> redisTemplate, String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public static boolean lSet(RedisTemplate<String, Object> redisTemplate, String key, Object value, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0)
                expire(redisTemplate, key, time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param
     * @return
     */
    public static boolean lSet(RedisTemplate<String, Object> redisTemplate, String key, List<Object> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public static boolean lSet(RedisTemplate<String, Object> redisTemplate, String key, List<Object> value, long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            if (time > 0)
                expire(redisTemplate, key, time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据索引修改list中的某条数据
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return
     */
    public static boolean lUpdateIndex(RedisTemplate<String, Object> redisTemplate, String key, long index,
                                       Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除N个值为value
     *
     * @param key   键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    public static long lRemove(RedisTemplate<String, Object> redisTemplate, String key, long count, Object value) {
        try {
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}

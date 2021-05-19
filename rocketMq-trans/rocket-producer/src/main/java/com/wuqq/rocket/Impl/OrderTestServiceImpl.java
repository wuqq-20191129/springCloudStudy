package com.wuqq.rocket.Impl;

import com.alibaba.fastjson.JSON;
import com.wuqq.rocket.config.ProducerConfig;
import com.wuqq.rocket.entity.OrderTest;
import com.wuqq.rocket.mapper.OrderTestMapper;
import com.wuqq.rocket.service.IOrderTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuqq
 * @since 2021-05-19
 */
@Service
public class OrderTestServiceImpl extends ServiceImpl<OrderTestMapper, OrderTest> implements IOrderTestService {

    private static Logger logger = LoggerFactory.getLogger(OrderTestServiceImpl.class);

    @Value("${rocketmq.topic}")
    private String topic;
    @Value("${rocketmq.tags}")
    private String tags;

    public   static  ConcurrentHashMap<String, Boolean> localTrans = new ConcurrentHashMap<>();

    @Autowired
    TransactionMQProducer producer;



    @Override
    public boolean save(OrderTest entity) {
        boolean result =false;
        Message message = new Message(topic,tags, JSON.toJSONBytes(entity));
        try {
            producer.sendMessageInTransaction(message,null);
            result = true;
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean saveFortest(OrderTest entity,String transactionId) {
        boolean result =false;
        int n= this.baseMapper.insert(entity,transactionId);
        if(n>0){
          result = true;
        }
        localTrans.put(transactionId,result);
        logger.info("订单创建完成......");
        return result;
    }



}

package com.wuqq.rocket.config;

import com.alibaba.fastjson.JSONObject;
import com.wuqq.rocket.Impl.OrderTestServiceImpl;
import com.wuqq.rocket.entity.OrderTest;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Classname TransactionListener
 * @Description TODO
 * @Date 2021/5/19 11:07
 * @Created by mh
 */
@Component
public class TransactionListenerImpl implements TransactionListener {

    private static Logger logger = LoggerFactory.getLogger(TransactionListenerImpl.class);

    @Autowired
    OrderTestServiceImpl orderTestService;
    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        logger.info("开始执行本地事务....");
        LocalTransactionState state;
        try{
            String body = new String(msg.getBody());
            OrderTest order = JSONObject.parseObject(body, OrderTest.class);
            orderTestService.saveFortest(order,msg.getTransactionId());
            state = LocalTransactionState.COMMIT_MESSAGE;
            logger.info("本地事务已提交。{}",msg.getTransactionId());
        }catch (Exception e){
            logger.info("执行本地事务失败。{}",e);
            state = LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return state;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        logger.info("开始回查本地事务状态。{}",msg.getTransactionId());
        LocalTransactionState state;
        String transactionId = msg.getTransactionId();
        if (OrderTestServiceImpl.localTrans.get(transactionId)){
            state = LocalTransactionState.COMMIT_MESSAGE;
        }else {
            state = LocalTransactionState.UNKNOW;
        }
        logger.info("结束本地事务状态查询：{}",state);
        return state;
    }
}

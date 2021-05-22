package com.wuqq.consumer.config;

import com.alibaba.fastjson.JSON;
import com.wuqq.consumer.entry.OrderTest;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author: wuqq
 * @date: 2021/5/22 11:07 AM
 * @version: 1.0
 */
@Component
public class MessageTestListener implements MessageListenerConcurrently {

    private static Logger logger = LoggerFactory.getLogger(MessageTestListener.class);
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        if (CollectionUtils.isEmpty(list)){
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }

        for(MessageExt msg:list){
            logger.info("接受到的消息为:"+JSON.parseObject(msg.getBody(), OrderTest.class));
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}

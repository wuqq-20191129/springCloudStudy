package com.wuqq.consumer.config;

//import org.apache.rocketmq.client.consumer.listener.MessageListener;
import com.alibaba.fastjson.JSONObject;
import com.wuqq.consumer.entity.OrderTest;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Classname ConsumeListener
 * @Description TODO
 * @Date 2021/5/20 9:38
 * @Created by mh
 */
@Component
public class ConsumeListener implements MessageListenerConcurrently {
    private static Logger logger = LoggerFactory.getLogger(ConsumeListener.class);

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

        if(CollectionUtils.isEmpty(msgs)){
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        logger.info("消费者线程监听到消息。");
        try{
            for (MessageExt message:msgs) {
                logger.info("开始处理订单数据，准备增加积分....");
                com.wuqq.consumer.entity.OrderTest order  = JSONObject.parseObject(message.getBody(), OrderTest.class);

                logger.info("消费消息：{}",order.toString());
                //pointsService.increasePoints(order);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }catch (Exception e){
            logger.error("处理消费者数据发生异常。{}",e);
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }

    }
}

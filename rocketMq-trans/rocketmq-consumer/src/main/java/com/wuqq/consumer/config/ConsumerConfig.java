package com.wuqq.consumer.config;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wuqq
 * @date: 2021/5/22 10:58 AM
 * @version: 1.0
 */
@Configuration
public class ConsumerConfig {

    private static Logger logger = LoggerFactory.getLogger(ConsumerConfig.class);

    @Value("${rocketmq.group}")
    private String group;

    @Value("${rocketmq.namesrv}")
    private String namesrv;

    @Value("${rocketmq.consumeMinThread}")
    private int min;

    @Value("${rocketmq.consumeMaxThread}")
    private int max;

    @Value("${rocketmq.topic}")
    private String topic;

    @Value("${rocketmq.tags}")
    private String tags;

    @Autowired
    private MessageTestListener listener;

    @Bean
    public DefaultMQPushConsumer getConsumer(){
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();

        try {
            consumer.setConsumerGroup(group);
            consumer.setNamesrvAddr(namesrv);
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            consumer.setConsumeThreadMax(max);
            consumer.setConsumeThreadMin(min);
            consumer.setMessageListener(listener);
            consumer.subscribe(topic,tags);
            consumer.start();
            logger.info("消费者启动......");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        return consumer;
    }

}

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
 * @Classname Consumer
 * @Description TODO
 * @Date 2021/5/20 9:28
 * @Created by mh
 */
@Configuration
public class Consumer {

    private static Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Value("${rocketmq.group}")
    private String group;

    @Value("${rocketmq.namesrv}")
    private String namesrv;

    @Value("${rocketmq.consumeMessageBatchSize}")
    private int size;

    @Value("${rocketmq.consumeMaxThread}")
    private  int max;

    @Value("${rocketmq.consumeMinThread}")
    private int min;

    @Value("${rocketmq.topic}")
    private String topic;

    @Value("${rocketmq.tags}")
    private String tags;

    @Autowired
    private  ConsumeListener listener;
    @Bean
    public DefaultMQPushConsumer getConsumer(){
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();

        consumer.setConsumerGroup(group);
        consumer.setNamesrvAddr(namesrv);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        consumer.setConsumeMessageBatchMaxSize(size);
        consumer.setConsumeThreadMax(max);
        consumer.setConsumeThreadMin(min);
        consumer.setMessageListener(listener);

        try {
            consumer.subscribe(topic,"*");

            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        return consumer;
    }
}

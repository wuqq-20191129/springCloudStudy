package com.wuqq.rocketcfg;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname ProducerCfg
 * @Description TODO
 * @Date 2021/4/30 16:09
 * @Created by mh
 */

@Configuration
public class ProducerCfg {

    private static Logger log = LoggerFactory.getLogger(ProducerCfg.class);

    @Value("${rocketmq.producer.groupName}")
    private String group;

    @Value("${rocketmq.producer.namesrvAddr}")
    private String namesrvAddr;

    @Value("${rocketmq.producer.maxMessageSize}")
    private Integer maxMessageSize;

    @Value("${rocketmq.producer.sendMsgTimeout}")
    private Integer sendMsgTimeout;

    @Value("${rocketmq.producer.retryTimesWhenSendFailed}")
    private Integer retryTimes;

    @Bean
    public DefaultMQProducer getProducer(){

        DefaultMQProducer producer = new DefaultMQProducer();
        producer.setProducerGroup(this.group);

        producer.setNamesrvAddr(this.namesrvAddr);

        producer.setMaxMessageSize(this.maxMessageSize);

        producer.setSendMsgTimeout(this.sendMsgTimeout);

        producer.setRetryTimesWhenSendFailed(this.retryTimes);

        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        return producer;
    }
}

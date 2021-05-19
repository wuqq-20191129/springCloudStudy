package com.wuqq.rocket.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @Classname ProducerConfig
 * @Description TODO
 * @Date 2021/5/19 11:06
 * @Created by mh
 */
@Configuration
public class ProducerConfig {

    private static Logger logger = LoggerFactory.getLogger(ProducerConfig.class);

    @Value("${rocketmq.group}")
    private String proGroup;

    @Value("${rocketmq.namesrv}")
    private String namesrv;

    @Value("${rocketmq.maxMessageSize}")
    private int maxMessageSize;

    @Value("${rocketmq.sendTimeout}")
    private int timeout;

    @Value("${rocketmq.retryTimes}")
    private int times;


    @Autowired
    private TransactionListenerImpl listener;

    @Bean
    public TransactionMQProducer getProducer(){
            TransactionMQProducer producer = new TransactionMQProducer();
            ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2000)
                    , new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread();
                    thread.setName("check-thread");
                    return thread;
                }
            });
            producer.setProducerGroup(proGroup);
            producer.setNamesrvAddr(namesrv);
            producer.setMaxMessageSize(maxMessageSize);
            producer.setSendMsgTimeout(timeout);

            producer.setRetryTimesWhenSendFailed(times);

            producer.setExecutorService(executorService);

            producer.setTransactionListener(listener);

        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        return producer;
    }
}

package com.wuqq.rocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname RocketConsumerApplication
 * @Description TODO
 * @Date 2021/5/19 10:48
 * @Created by mh
 */
@SpringBootApplication
public class RocketConsumerApplication {


    private static Logger logger = LoggerFactory.getLogger(RocketConsumerApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(RocketConsumerApplication.class,args);
        logger.info("程序启动中......");
    }
}

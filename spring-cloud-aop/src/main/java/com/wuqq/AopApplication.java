package com.wuqq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: wuqq
 * @date: 2021/6/10 10:19 AM
 * @version: 1.0
 */
@SpringBootApplication
public class AopApplication {

    private static Logger logger = LoggerFactory.getLogger(AopApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class,args);
        logger.info("程序启动中......");
    }
}

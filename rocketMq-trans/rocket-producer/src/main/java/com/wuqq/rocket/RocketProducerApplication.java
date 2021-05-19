package com.wuqq.rocket;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname RocketProducerApplication
 * @Description TODO
 * @Date 2021/5/19 10:47
 * @Created by mh
 */
@SpringBootApplication
@MapperScan("com.wuqq.rocket.mapper")
public class RocketProducerApplication {


    private static Logger logger = LoggerFactory.getLogger(RocketProducerApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(RocketProducerApplication.class,args);
        logger.info("程序启动中......");
    }
}

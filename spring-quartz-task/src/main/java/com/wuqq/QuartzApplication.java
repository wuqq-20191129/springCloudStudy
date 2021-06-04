package com.wuqq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname QuartzApplication
 * @Description TODO
 * @Date 2021/5/31 9:46
 * @Created by mh
 */

@SpringBootApplication
public class QuartzApplication {

    private static Logger logger = LoggerFactory.getLogger(QuartzApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class,args);
        logger.info("程序启动中......");
    }
}

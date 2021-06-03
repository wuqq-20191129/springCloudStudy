package com.wuqq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname HttpTestApplication
 * @Description TODO
 * @Date 2021/6/2 15:38
 * @Created by mh
 */

@SpringBootApplication
public class HttpTestApplication {

    private static Logger logger = LoggerFactory.getLogger(HttpTestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HttpTestApplication.class);
        logger.info("程序启动中.....");
    }
}

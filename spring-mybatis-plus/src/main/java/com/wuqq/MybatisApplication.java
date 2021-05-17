package com.wuqq;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: wuqq
 * @date: 2021/5/16 10:11 PM
 * @version: 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = "com.wuqq.test.mapper")
public class MybatisApplication {
    private static  Logger logger = LoggerFactory.getLogger(MybatisApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class,args);
        logger.info("程序启动中......");
    }
}

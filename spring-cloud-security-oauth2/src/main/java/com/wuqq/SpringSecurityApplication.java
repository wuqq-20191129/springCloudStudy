package com.wuqq;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: wuqq
 * @date: 2021/5/29 10:49 AM
 * @version: 1.0
 */
@SpringBootApplication
@MapperScan("com.wuqq.oauth.mapper")
public class SpringSecurityApplication {
    private static Logger logger = LoggerFactory.getLogger(SpringSecurityApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class,args);

    }
}

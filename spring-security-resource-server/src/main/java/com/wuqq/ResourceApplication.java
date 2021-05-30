package com.wuqq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: wuqq
 * @date: 2021/5/30 10:12 AM
 * @version: 1.0
 */
@SpringBootApplication
@MapperScan("com.wuqq.oauth2.mapper")
public class ResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class,args);
    }
}

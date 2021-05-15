package com.wuqq;

import com.wuqq.source.Mysource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({Mysource.class})
public class RocketStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketStreamApplication.class,args);
        System.out.println("Stream for Rocketmq Started!......");
    }
}

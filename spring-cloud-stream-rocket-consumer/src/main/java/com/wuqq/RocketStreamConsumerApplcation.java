package com.wuqq;


import com.wuqq.source.MySink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({MySink.class})
public class RocketStreamConsumerApplcation {
    public static void main(String[] args) {
        SpringApplication.run(RocketStreamConsumerApplcation.class,args);
    }
}

package com.wuqq.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BasicConfig {

    @Bean
    // 使用@LoadBalanced restTemplate 接入ribbon
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

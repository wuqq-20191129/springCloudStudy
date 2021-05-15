package com.wuqq.config;

import com.wuqq.feign.TestServiceFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FeignCnfigration {

    @Bean
    public TestServiceFallback testServiceFallback(){
        return new TestServiceFallback();
    }
}

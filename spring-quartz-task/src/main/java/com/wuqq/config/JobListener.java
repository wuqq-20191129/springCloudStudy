package com.wuqq.config;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @Classname JobListener
 * @Description TODO
 * @Date 2021/5/31 16:27
 * @Created by mh
 */
@Configuration
public class JobListener implements ApplicationListener<ContextRefreshedEvent> {


    @Autowired
    private JobScheduler jobScheduler;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            jobScheduler.setScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}

package com.wuqq.config;

import com.wuqq.task.TestJob1;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @Classname QuartzConfig
 * @Description TODO
 * @Date 2021/5/31 15:45
 * @Created by mh
 */

@Configuration
public class QuartzConfig {
    private static Logger logger = LoggerFactory.getLogger(QuartzConfig.class);

    ////测试定时Job1
    //@Bean
    //public JobDetail testJob1(){
    //    return JobBuilder.newJob(TestJob1.class).withIdentity("TestJob1").storeDurably().build();
    //}
    //
    ////触发器trigger1
    //@Bean
    //public Trigger testTrigger1(){
    //    SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
    //            .withIntervalInSeconds(5)
    //            .repeatForever();
    //    return TriggerBuilder.newTrigger().forJob(testJob1()).withIdentity("TestJob1").withSchedule(simpleScheduleBuilder).build();
    //}

    /**
     *
     * @Description 初始化调度器工厂
     * @Param
     * @param
     * @Return
     * @Date    2021/5/31 16:13
     * @Created by ${USER}
     */
    public SchedulerFactoryBean schedulerFactory(){
        return new SchedulerFactoryBean();
    }
}

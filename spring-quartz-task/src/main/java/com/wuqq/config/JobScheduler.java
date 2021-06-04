package com.wuqq.config;

import com.wuqq.task.TestJob1;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Classname JobScheduler
 * @Description TODO
 * @Date 2021/5/31 16:17
 * @Created by mh
 */
@Component
public class JobScheduler {
    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    private Scheduler scheduler;

    public void setScheduler() throws SchedulerException {
        scheduler = schedulerFactoryBean.getScheduler();
        start();
    }

    //添加定时任务
    public void start() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(TestJob1.class).withIdentity("TestJob1","Group1").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/10  * * * * ?");
        CronTrigger cronTrigger =TriggerBuilder.newTrigger().withIdentity("Trigger1","Group1").withSchedule(scheduleBuilder).build();

        scheduler.scheduleJob(jobDetail,cronTrigger);
    }
}

package com.wuqq.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname TestJob1
 * @Description TODO
 * @Date 2021/5/31 15:49
 * @Created by mh
 */
public class TestJob1 implements Job {

    private static Logger logger = LoggerFactory.getLogger(TestJob1.class);
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("testjob1 started  .......");
    }
}

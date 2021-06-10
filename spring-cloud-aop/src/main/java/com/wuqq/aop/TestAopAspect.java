package com.wuqq.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: wuqq
 * @date: 2021/6/10 10:37 AM
 * @version: 1.0
 */
@Aspect
@Component
public class TestAopAspect {

    private static Logger logger = LoggerFactory.getLogger(TestAopAspect.class);


    @Pointcut(value = "@annotation(testAop)")
    public void pointcut(TestAop testAop){

    }

    //advice(通知) 包括before after AfterReturning AfterThrowing Around 五种
    @Before("pointcut(testAop)")
    public void before(TestAop testAop){
        logger.info("aop before");
    }

    @After("pointcut(testAop)")
    public void after(TestAop testAop){
        logger.info("after aop");
    }


    //最前和最后执行  proceedingJoinPoint.proceed()传递filter ProceedingJoinPoint继承joinPoint 即为连接点
    @Around(value = "pointcut(testAop)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint,TestAop testAop) throws Throwable {
        logger.info("around api");
        String methodName = proceedingJoinPoint.getSignature().getName();
        logger.info("methodName{}",methodName);
        Object result= proceedingJoinPoint.proceed();
        logger.info("around api end!");
        return result;
    }


}

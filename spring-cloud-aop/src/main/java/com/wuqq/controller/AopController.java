package com.wuqq.controller;

import com.wuqq.aop.TestAop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wuqq
 * @date: 2021/6/10 11:04 AM
 * @version: 1.0
 */
@RestController
public class AopController {

    private static Logger logger = LoggerFactory.getLogger(AopController.class);

    @GetMapping("/test")
    @TestAop
    public String test(){
        logger.info("rest api!!!!");
        return "success";
    }
}

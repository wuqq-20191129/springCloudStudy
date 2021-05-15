package com.wuqq.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/config")
//@RefreshScope
public class ConfigController {

//    @Value("${useLocalCache:false}")
//    private boolean useLocalCache;
//
//    @RequestMapping("/get")
//    public boolean get() {
//        return useLocalCache;
//    }

    @Value("${config}")
    private String config;

    @GetMapping("/config")
    public String getConfig() {
        return config;
    }

}

package com.wuqq.controller;


import com.wuqq.feign.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TestService testService;

    @GetMapping("/testFromConsumer/{str}")
    public String getString(@PathVariable String str){
        return restTemplate.getForObject("http://nacos-provider/testRibbon/"+str,String.class);
    }

    @GetMapping("/feign/{str}")
    public String getFromFeign(@PathVariable String str){
        return testService.getFromFeign(str);
    }
}

package com.wuqq;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/testRibbon/{str}")
    public String getString(@PathVariable String str){
        return "hello"+str;
    }


}

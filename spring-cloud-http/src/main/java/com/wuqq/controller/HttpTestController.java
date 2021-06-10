package com.wuqq.controller;

import com.wuqq.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname HttpTestController
 * @Description TODO
 * @Date 2021/6/2 15:42
 * @Created by mh
 */

@RestController
public class HttpTestController {

    private static Logger logger = LoggerFactory.getLogger(HttpTestController.class);


    @GetMapping("/test")
    public String getTestNoParam(){

        //logger.info("接收到的实体={}",user.toString());
        logger.info("GetMapping Test");
        return "hello test";
    }

    //http://localhost:8080/httpget?username=wuqq&password=123456&age=20
    //实体类接收
    @GetMapping("/httpget")
    public void getTest(@RequestBody User user){

        logger.info("接收到的实体={}",user.toString());
        logger.info("GetMapping Test");
    }


    //http://localhost:8080/httpget?username=wuqq&password=123456&age=20
    //HttpServletRequest 接收
    @GetMapping("getfromhttp")
    public void getTest1(HttpServletRequest request, HttpServletResponse response){
            String username = request.getParameter("username");
            logger.info("username="+username);
    }


    //http://localhost:8080/httpget?username=wuqq&password=123456&age=20
    //路径中后传值  直接获取  参数名称须一致
    @GetMapping("getafterurl")
    public String getTest2(String username , String password ,int age){
        logger.info("username="+username);
        logger.info("password="+password);
        logger.info("age="+age);
        return "收到请求";
    }


    //http://localhost:8080/httpget?username=wuqq&password=123456&age=20
    //路径后传值  指定参数名 可以取别名 使用@RequestParam注解
    @GetMapping("getafterurlf1")
    public void getTest3(@RequestParam("username") String name ,@RequestParam("password") String psd ,@RequestParam("age") int temp){
        logger.info("username="+name);
        logger.info("password="+psd);
        logger.info("age="+temp);
    }


        //http://localhost:8080/get/wuqq/123456/20
    //路径中传值  参数作为路径的一部分 使用@PathVariable 也可取别名
    @GetMapping("get/{username}/{password}/{age}")
    public void getTest4(@PathVariable("username") String name , @PathVariable("password") String psd , @PathVariable("age") int temp){
        logger.info("username="+name);
        logger.info("password="+psd);
        logger.info("age="+temp);
    }

    //https://localhost:8080/httppost
    //post测试 postman 测试
    //无参数
    @PostMapping("/httppost")
    public void postTest(){

        //logger.info("接收到的实体={}",user.toString());
        logger.info("postmapping Test");
    }

    //实体类接收
    //post测试 postman 测试
    //https://localhost:8080/httppost
    //数据位于body form表单
    @PostMapping("/postforentity")
    public void postTest1(User user){

        logger.info("接收到的实体={}",user.toString());
        logger.info("postmapping Test");
    }

    //实体类接收
    //post测试 postman 测试
    //https://localhost:8080/httppost
    //数据位于body  json 方式 需在入参配合@RequestBodyz 注解
    @PostMapping("/postforjson")
    public void postTest2(@RequestBody User user){

        logger.info("接收到的实体={}",user.toString());
        logger.info("postmapping Test");
    }
}

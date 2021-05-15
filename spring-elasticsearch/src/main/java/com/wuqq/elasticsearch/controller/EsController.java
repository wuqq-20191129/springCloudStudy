package com.wuqq.elasticsearch.controller;

import com.wuqq.elasticsearch.dao.ItemDao;
import com.wuqq.elasticsearch.entry.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname EsController
 * @Description TODO
 * @Date 2021/5/12 11:09
 * @Created by mh
 */
@Controller
@RequestMapping("/es")
public class EsController {

    private  static  Logger logger = LoggerFactory.getLogger(EsController.class);

    @Autowired
    private ItemDao itemDao;

    @GetMapping("/add")
    public String  add(){
        Item item = new Item();
        item.setId((long)1);
        item.setBrand("wuqq");
        item.setCategory("测试");
        item.setImages("sssssss");
        item.setPrice(3.00);
        item.setTitle("哈哈");
        try {
            itemDao.save(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}

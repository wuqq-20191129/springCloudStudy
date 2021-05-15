package com.wuqq.controller;


import com.wuqq.message.DemoMessage;
import com.wuqq.source.Mysource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/rocketForStream")
public class MessageController {

    @Autowired
    private Mysource mysource;
    @GetMapping("/sendMsg")
    public boolean send(){
        DemoMessage message = new DemoMessage();
        message.setId(new Random().nextInt());
        Message<DemoMessage> testMessage = MessageBuilder.withPayload(message).build();
        return mysource.oringinal().send(testMessage);
    }
}

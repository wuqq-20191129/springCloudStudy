package com.wuqq.consumer;


import com.wuqq.message.DemoMessage;
import com.wuqq.source.MySink;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class DemoConsumer {

    @StreamListener(MySink.original)
    public void getMessage( DemoMessage demoMessage){
        System.out.println("收到消息："+ demoMessage.toString());
    }
}





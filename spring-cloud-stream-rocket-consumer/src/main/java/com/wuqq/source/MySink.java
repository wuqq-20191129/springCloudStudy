package com.wuqq.source;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MySink {

    String original = "original";
    @Input(original)
    SubscribableChannel original();
}

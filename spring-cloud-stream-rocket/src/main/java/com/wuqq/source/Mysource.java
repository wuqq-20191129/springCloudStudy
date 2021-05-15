package com.wuqq.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Mysource {

    @Output("oringinal")
    MessageChannel  oringinal();

}

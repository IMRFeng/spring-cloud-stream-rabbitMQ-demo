package com.example.demo.topic;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RabbitMQProcessor {
    String INPUT_DEMO = "inputDemo";

    @Input SubscribableChannel inputDemo();
}

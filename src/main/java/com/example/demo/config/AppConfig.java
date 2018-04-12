package com.example.demo.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class AppConfig {

    @Value("${demo.rabbit.mq.retry.backOffPeriod}")
    private Long retryBackOffPeriod;

    @Value("${demo.rabbit.mq.retry.maxAttempts}")
    private Integer retryMaxAttempts;

}
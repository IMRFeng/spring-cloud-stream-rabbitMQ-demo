package com.example.demo.listener;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.topic.RabbitMQProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
@EnableBinding(RabbitMQProcessor.class)
@Retryable(value = {IOException.class, TimeoutException.class},
        maxAttemptsExpression = "#{@appConfig.getRetryMaxAttempts()}",
        backoff = @Backoff(delayExpression = "#{@appConfig.getRetryBackOffPeriod()}"))
public class RabbitMQListener {

    /** To simplify the application I just directly call the repository here, but you may need add a service layer as required */
    private EmployeeRepository employeeRepository;

    @StreamListener(RabbitMQProcessor.INPUT_DEMO)
    public void processInputDemoTopicMessage(Message<Employee> message) {
        Employee emp = message.getPayload();
        System.out.println("Received Emp message: " + emp);
        this.employeeRepository.save(emp);
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}

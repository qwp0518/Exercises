package com.example.springmqdirectprovider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SendError {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${RabbitMQ.config.exchange}")
    private String exchage;

    @Value("${RabbitMQ.config.queue.error.routing-key}")
    private String routingkey;

    public void sendError(String msg){
        amqpTemplate.convertAndSend(exchage,routingkey,msg);
    }
}

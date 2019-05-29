package com.example.springmqdirectprovider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${RabbitMQ.config.exchange}")
    private String exchange;

    @Value("${RabbitMQ.config.queue.info.routing-key}")
    private String routingkey;

    public void send(String msg){
        this.amqpTemplate.convertAndSend(exchange,routingkey,msg);
    }
}

package com.example.springmqtopicproducer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${RabbitMQ.config.exchange}")
    private String exchange;


    public void send(String msg) {
        this.amqpTemplate.convertAndSend(exchange, "user.log.debug", "user.log.debug" + msg);
        this.amqpTemplate.convertAndSend(exchange, "user.log.info", "user.log.info" + msg);
        this.amqpTemplate.convertAndSend(exchange, "user.log.warn", "user.log.warn" + msg);
        this.amqpTemplate.convertAndSend(exchange, "user.log.error", "user.log.error" + msg);
    }
}

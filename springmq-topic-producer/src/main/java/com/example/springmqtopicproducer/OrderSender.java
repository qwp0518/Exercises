package com.example.springmqtopicproducer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${RabbitMQ.config.exchange}")
    private String exchange;


    public void send(String msg){
        this.amqpTemplate.convertAndSend(exchange,"order.log.debug","order.log.debug" + msg);
        this.amqpTemplate.convertAndSend(exchange,"order.log.info","order.log.info" + msg);
        this.amqpTemplate.convertAndSend(exchange,"order.log.warn","order.log.warn" + msg);
        this.amqpTemplate.convertAndSend(exchange,"order.log.error","order.log.error" + msg);
    }
}

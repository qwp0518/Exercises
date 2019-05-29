package com.example.springmqtopicproducer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${RabbitMQ.config.exchange}")
    private String exchange;


    public void send(String msg) {
        this.amqpTemplate.convertAndSend(exchange, "product.log.debug", "product.log.debug" + msg);
        this.amqpTemplate.convertAndSend(exchange, "product.log.info", "product.log.info" + msg);
        this.amqpTemplate.convertAndSend(exchange, "product.log.warn", "product.log.warn" + msg);
        this.amqpTemplate.convertAndSend(exchange, "product.log.error", "product.log.error" + msg);
    }
}

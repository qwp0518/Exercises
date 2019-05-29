package com.example.springmqdirectconsumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${RabbitMQ.config.queue.error}",autoDelete = "true"),
                exchange = @Exchange(value = "${RabbitMQ.config.exchange}",type = ExchangeTypes.DIRECT),
                key = "${RabbitMQ.config.queue.error.routing-key}"))
public class ErrorReceiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("Error receiver: " + msg);
    }
}

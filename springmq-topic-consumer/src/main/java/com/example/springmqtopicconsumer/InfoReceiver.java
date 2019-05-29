package com.example.springmqtopicconsumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${RabbitMQ.config.queue.info}"),
                exchange = @Exchange(value = "${RabbitMQ.config.exchange}",type = ExchangeTypes.TOPIC),
                key = "*.log.info")
)
public class InfoReceiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("info receiver: " + msg);
    }
}

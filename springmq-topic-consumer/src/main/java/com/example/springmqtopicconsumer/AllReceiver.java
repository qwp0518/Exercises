package com.example.springmqtopicconsumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${RabbitMQ.config.queue.all}"),
                exchange = @Exchange(value = "${RabbitMQ.config.exchange}",type = ExchangeTypes.TOPIC),
                key = "*.log.*")
)
public class AllReceiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("All receiver: " + msg);
    }
}

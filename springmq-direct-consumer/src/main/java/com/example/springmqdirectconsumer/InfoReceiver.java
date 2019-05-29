package com.example.springmqdirectconsumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${RabbitMQ.config.queue.info}"),
                exchange = @Exchange(value = "${RabbitMQ.config.exchange}",type = ExchangeTypes.DIRECT),
                key = "${RabbitMQ.config.queue.info.routing-key}")
)
public class InfoReceiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("info receiver: " + msg);
    }
}

package com.peter.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述:接收者
 *
 **/
@Component
@RabbitListener(queues = "fanout.peter.net")
public class FanoutReceiver1 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("接收者 FanoutReceiver1," + message);
    }
}

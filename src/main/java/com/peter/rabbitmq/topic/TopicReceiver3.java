package com.peter.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述: 接收者
 *
 */
@Component
@RabbitListener(queues = "topic.ymq")
public class TopicReceiver3 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("接收者 TopicReceiver3," + message);
    }

}

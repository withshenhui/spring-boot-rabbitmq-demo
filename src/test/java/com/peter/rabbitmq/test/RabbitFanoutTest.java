package com.peter.rabbitmq.test;

import com.peter.rabbitmq.run.Startup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 描述: 广播模式或者订阅模式队列
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Startup.class)
public class RabbitFanoutTest {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Test
    public void sendPeterTest() {

        String context = "此消息在，广播模式或者订阅模式队列下，有 FanoutReceiver1 FanoutReceiver2 可以收到";

        String routeKey = "topic.peter.net";

        String exchange = "fanoutExchange";

        System.out.println("sendPeterTest : " + context);

        context = "context:" + exchange + ",routeKey:" + routeKey + ",context:" + context;

        this.rabbitTemplate.convertAndSend(exchange, routeKey, context);
    }

    @Test
    public void sendMangoKeeperTest() {

        String context = "此消息在，广播模式或者订阅模式队列下，有 FanoutReceiver1 FanoutReceiver2 可以收到";

        String routeKey = "topic.mangokeeper.com";

        String exchange = "fanoutExchange";

        context = "context:" + exchange + ",routeKey:" + routeKey + ",context:" + context;

        System.out.println("sendMangoKeeperTest : " + context);

        this.rabbitTemplate.convertAndSend(exchange, routeKey, context);
    }
}

package com.zzl.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class RabbitmqApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMsg() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            // 消息内容
            String message = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 创建订单.";
            this.rabbitTemplate.convertAndSend("order_exchange","order.save", message);
            Thread.sleep(i * 10);
        }
    }

}

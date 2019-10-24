package com.zzl.rabbitmq.springboot;

import org.joda.time.DateTime;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author john（coder_john@163.com）
 * @desc 接收1
 * @date 2019-10-22
 */
@Component
@RabbitListener(queues = "dlx.queue")
public class Receive1 {

    @RabbitHandler
    public void process(String msg) {
        String now = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        System.out.println(now + " 死信队列接收到消息：" + msg);
    }
}

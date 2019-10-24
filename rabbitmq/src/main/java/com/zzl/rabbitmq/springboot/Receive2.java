package com.zzl.rabbitmq.springboot;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author john（coder_john@163.com）
 * @desc 接收2
 * @date 2019-10-22
 */
@Component
@RabbitListener(queues = "test_queue_work")
public class Receive2 {

    @RabbitHandler
    public void process(String msg) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Receiver2  : " + msg);
    }
}

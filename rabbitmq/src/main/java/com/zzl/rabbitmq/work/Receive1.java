package com.zzl.rabbitmq.work;

import com.rabbitmq.client.*;
import com.zzl.rabbitmq.util.ConnectionUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author john（coder_john@163.com）
 * @desc 接收1
 * @date 2019-10-21
 */
public class Receive1 {

    private final static String QUEUE_NAME = "test_queue_work";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.basicQos(1);
        // 定义队列的消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, StandardCharsets.UTF_8);
                System.out.println("Recieve msg:" + msg);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        // 监听队列
        channel.basicConsume(QUEUE_NAME, false, defaultConsumer);
        System.out.println("Recieve msg end...");
    }
}

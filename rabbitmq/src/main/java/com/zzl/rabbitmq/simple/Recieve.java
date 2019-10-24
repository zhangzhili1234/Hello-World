package com.zzl.rabbitmq.simple;

import com.rabbitmq.client.*;
import com.zzl.rabbitmq.util.ConnectionUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author john（coder_john@163.com）
 * @desc 接收
 * @date 2019-10-21
 */
public class Recieve {

    private final static String QUEUE_NAME = "q_test_01";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 定义队列的消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, StandardCharsets.UTF_8);
                System.out.println("Recieve msg:" + msg);
            }
        };
        // 监听队列
        channel.basicConsume(QUEUE_NAME, true, defaultConsumer);
        System.out.println("Recieve msg end...");

    }
}

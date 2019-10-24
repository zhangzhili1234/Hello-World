package com.zzl.rabbitmq.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zzl.rabbitmq.util.ConnectionUtil;

/**
 * @author john（coder_john@163.com）
 * @desc 发送
 * @date 2019-10-22
 */
public class Send {

    private final static String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        // 消息内容
        for (int i = 0; i < 10; i++) {
            // 消息内容
            String message = "hello " + i;
            channel.basicPublish(EXCHANGE_NAME, "insert.1", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
            Thread.sleep(i * 10);
        }
        channel.close();
        connection.close();
    }
}

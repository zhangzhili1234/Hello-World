package com.zzl.rabbitmq.util;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

/**
 * @author john（coder_john@163.com）
 * @desc 连接rabbitmq
 * @date 2019-10-21
 */
public class ConnectionUtil {

    public static Connection getConnection() throws Exception {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost("192.168.0.27");
        //端口
        factory.setPort(5672);
        //设置账号信息，用户名、密码、vhost
        factory.setUsername("guest");
        factory.setPassword("guest");
        // 通过工程获取连接
        return factory.newConnection();
    }
}

package com.zzl.rabbitmq.springboot;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author john（coder_john@163.com）
 * @desc 配置
 * @date 2019-10-22
 */
@Configuration
public class RabbitConfig {

    /**
     * 消费队列
     */
    private static final String orderExchangeName = "order_exchange";
    private static final String orderQueueName = "order_queue";
    private static final String orderRoutingKey = "order.#";

    /**
     * 死信队列配置
     */
    private static final String dlxExchangeName = "dlx.exchange";
    private static final String dlxQueueName = "dlx.queue";
    private static final String dlxRoutingKey = "#";

    @Bean
    public Queue orderQueue() {
        Map<String, Object> arguments = new HashMap<>(16);
        arguments.put("x-dead-letter-exchange",dlxExchangeName);
        arguments.put("x-message-ttl", 10000);
        return new Queue(orderQueueName, true, false, false, arguments);
    }

    @Bean
    public TopicExchange orderExchange() {
        return new TopicExchange(orderExchangeName, true, false, null);
    }

    @Bean
    public Binding orderBinding() {
        return BindingBuilder.bind(orderQueue()).to(orderExchange()).with(orderRoutingKey);
    }

    @Bean
    public Queue dlxQueue() {
        return new Queue(dlxQueueName, true, false, false, null);
    }

    @Bean
    public TopicExchange dlxExchange() {
        return new TopicExchange(dlxExchangeName, true, false, null);
    }

    @Bean
    public Binding dlxBinding() {
        return BindingBuilder.bind(dlxQueue()).to(dlxExchange()).with(dlxRoutingKey);
    }
}

package com.zzl.rabbitmq.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author john（coder_john@163.com）
 * @desc
 * @date 2019-10-23
 */
@Slf4j
public class RabbitConfirmCallback implements RabbitTemplate.ConfirmCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("(start)生产者消息确认=========================");
        log.info("correlationData:[{}]", correlationData);
        log.info("ack:[{}]", ack);
        log.info("cause:[{}]", cause);
        if (!ack) {
            log.info("消息可能未到达rabbitmq服务器");
        }
        log.info("(end)生产者消息确认=========================");
    }
}

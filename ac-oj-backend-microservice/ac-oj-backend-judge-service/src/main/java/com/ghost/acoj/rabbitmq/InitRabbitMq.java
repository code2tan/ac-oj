package com.ghost.acoj.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

/**
 * 用于创建测试程序用到的交换机和队列（只用在程序启动前执行一次）
 */
@Slf4j
public class InitRabbitMq {
    private static final String HOST = "www.ghost-ubuntu.org";
    private static final String EXCHANGE_NAME = "code_exchange";
    private static final String QUEUE_NAME = "code_queue";

    @PostConstruct
    public static void doInit() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(HOST);
            factory.setUsername("admin");
            factory.setPassword("admin");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            // 声明交换机
            channel.exchangeDeclare(EXCHANGE_NAME, "direct", true);
            // 声明队列
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            // 绑定队列到交换机
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "my_routingKey");
            log.info("消息队列启动成功!");
        } catch (Exception e) {
            log.error("消息队列启动失败");
        }
    }

    public static void main(String[] args) {
        doInit();
    }
}

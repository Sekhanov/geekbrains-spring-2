package com.sekhanov.rabbitmqdemo.rabbitmqdemo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.PropertySource;

/**
 * RabbitMqReceiver
 */
@PropertySource("classpath:/rabbitmq.properties")
@RabbitListener(queues = "${msg.queue.name}")
public class RabbitMqReceiver {

    @RabbitHandler
    public void receiver(TextMessage textMessage) {
        System.out.println(textMessage.getText());
    }
    
}
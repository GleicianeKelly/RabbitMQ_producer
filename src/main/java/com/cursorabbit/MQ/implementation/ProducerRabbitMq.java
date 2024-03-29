package com.cursorabbit.MQ.implementation;

import com.cursorabbit.MQ.amqp.AmqpProducer;
import com.cursorabbit.MQ.dto.MessageQueue;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerRabbitMq implements AmqpProducer<MessageQueue> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    @Override
    public void producer(MessageQueue message) {
        try{
            rabbitTemplate.convertAndSend(exchange, queue, message);
        }catch (Exception e){
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}

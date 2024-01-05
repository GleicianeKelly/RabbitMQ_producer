package com.cursorabbit.MQ.service.implementation;

import com.cursorabbit.MQ.amqp.AmqpProducer;
import com.cursorabbit.MQ.dto.MessageQueue;
import com.cursorabbit.MQ.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqService implements AmqpService {

    @Autowired
    private AmqpProducer<MessageQueue> amqp;

    @Override
    public void sendToConsumer(MessageQueue message) {
        amqp.producer(message);
    }
}

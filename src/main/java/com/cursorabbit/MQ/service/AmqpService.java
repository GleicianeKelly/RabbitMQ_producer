package com.cursorabbit.MQ.service;


import com.cursorabbit.MQ.dto.MessageQueue;

public interface AmqpService {


    void sendToConsumer(MessageQueue message);
}

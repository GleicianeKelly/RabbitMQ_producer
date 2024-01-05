package com.cursorabbit.MQ.amqp;

public interface AmqpProducer<T> {

    void producer(T t);
}

package com.example.rabbitmq.messaging.service;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;


@Service
public class RabbitMQReciever {

    private CountDownLatch latch = new CountDownLatch(1);

   // @RabbitHandler
  // @RabbitListener(queues = "employee-queue")
   @RabbitListener(queues = "HELLO_QUEUE")
    public void receive(Message in) {
        System.out.println(" [x] Received '" + new String(in.getBody()) + "'");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
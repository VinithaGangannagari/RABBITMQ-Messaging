package com.example.rabbitmq.messaging.service;

import com.example.rabbitmq.messaging.model.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("HELLO_EXCHANGE")
    private String exchange;

    @Value("HELLO_KEY")
    private String routingkey;


// private  RabbitMQReciever rabbitMQReciever;



    public void send(Employee company) throws Exception{
        rabbitTemplate.convertAndSend(exchange, routingkey,company);
        System.out.println("Send msg = " + company);
       // rabbitMQReciever.getLatch().await(10000, TimeUnit.MILLISECONDS);

    }
}

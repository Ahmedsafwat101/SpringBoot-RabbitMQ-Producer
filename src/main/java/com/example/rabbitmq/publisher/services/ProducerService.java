package com.example.rabbitmq.publisher.services;
import com.example.rabbitmq.publisher.exceptions.QueueNotFoundException;
import com.example.rabbitmq.publisher.models.CustomMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.rabbitmq.publisher.configurations.RabbitConfig.*;

@Service
@Slf4j
public class ProducerService {


    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    DirectExchange exchange;

    public void send(CustomMessage message,String queueName){
        if(queueName.equals(QUEUE_A)) {
            rabbitTemplate.convertAndSend(exchange.getName(), ROUTING_A, message);
        } else if(queueName.equals(QUEUE_B)) {
            rabbitTemplate.convertAndSend(exchange.getName(), ROUTING_B, message);
        } else {
            log.info("Message is sent successfully");
            throw new QueueNotFoundException("Queue Name isn't found");
        }

        log.info("Message is sent successfully");
    }
}

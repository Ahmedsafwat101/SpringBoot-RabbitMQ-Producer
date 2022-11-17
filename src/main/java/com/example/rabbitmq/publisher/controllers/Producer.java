package com.example.rabbitmq.publisher.controllers;

import com.example.rabbitmq.publisher.models.CustomMessage;
import com.example.rabbitmq.publisher.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.rabbitmq.publisher.configurations.RabbitConfig.QUEUE_A;
import static com.example.rabbitmq.publisher.configurations.RabbitConfig.QUEUE_B;

@RestController
public class Producer {

    @Autowired
    ProducerService producerService;

   @PostMapping("/post-message-queueA")
    public ResponseEntity<String> sendToQueueA(@RequestBody CustomMessage message){
       producerService.send(message,QUEUE_A);
       return ResponseEntity.ok("Message sent successfully");
    }

    @PostMapping("/post-message-queueB")
    public ResponseEntity<String> sendToQueueB(@RequestBody CustomMessage message){
        producerService.send(message,QUEUE_B);
        return ResponseEntity.ok("Message sent successfully");
    }

    @PostMapping("/post-message-all")
    public ResponseEntity<String> sendToAllQueues(@RequestBody CustomMessage message){
        producerService.sendToAll(message);
        return ResponseEntity.ok("Message sent successfully");
    }

    @PostMapping("/post-message-topic-a")
    public ResponseEntity<String> sendToAllQueuesByTopicA(@RequestBody CustomMessage message){
        producerService.sendToAllByTopic(message,QUEUE_A);
        return ResponseEntity.ok("Message sent successfully");
    }

    @PostMapping("/post-message-topic-b")
    public ResponseEntity<String> sendToAllQueuesByTopicB(@RequestBody CustomMessage message){
        producerService.sendToAllByTopic(message,QUEUE_B);
        return ResponseEntity.ok("Message sent successfully");
    }
}

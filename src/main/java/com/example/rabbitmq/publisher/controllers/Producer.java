package com.example.rabbitmq.publisher.controllers;

import com.example.rabbitmq.publisher.models.CustomMessage;
import com.example.rabbitmq.publisher.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {

    @Autowired
    ProducerService producerService;

   @PostMapping("/post-message")
    public ResponseEntity<String> send(@RequestBody CustomMessage message){
       producerService.send(message);
       return ResponseEntity.ok("Message sent successfully");
    }
}

package com.example.rabbitmq.publisher.exceptions;

public class QueueNotFoundException extends RuntimeException{
    public QueueNotFoundException(String message) {
        super(message);
    }
}

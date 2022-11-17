package com.example.rabbitmq.publisher.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomMessage {
    private int id;
    private String message;
    private boolean isSecret;
}

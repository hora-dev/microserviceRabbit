package com.onebit.microservicio.controllers;

import com.onebit.microservicio.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageController {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    MessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/message")
    public String sendMessage(@RequestBody String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, message);
        return "Mensaje enviado a RabbitMQ: " + message;
    }
}

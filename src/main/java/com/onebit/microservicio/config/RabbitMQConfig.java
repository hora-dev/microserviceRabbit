package com.onebit.microservicio.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "cola-ejemplo";
    public static final String EXCHANGE_NAME = "miExchange";
    public static final String ROUTING_KEY = "miRoutingKey";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true); // true indica que la cola es durable
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    // También puedes configurar otros beans como RabbitTemplate, AmqpAdmin, etc.
}

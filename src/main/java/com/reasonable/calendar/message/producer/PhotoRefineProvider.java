package com.reasonable.calendar.message.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PhotoRefineProvider implements CommandLineRunner {
    private static final String exchange = "photo-refine-exchange";
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args) {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(exchange, "reasonable.photo", "Hello Message!");
    }
}

package com.reasonable.calendar.message.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PhotoRefineTest implements CommandLineRunner {
    private static final String exchange = "photo-refine-exchange";
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args) {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(exchange, "reasonable.photo", "273e23d6-d327-4e71-b744-2d95d852d60b");
    }
}

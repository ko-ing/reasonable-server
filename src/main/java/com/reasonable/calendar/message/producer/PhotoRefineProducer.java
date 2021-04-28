package com.reasonable.calendar.message.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PhotoRefineProducer {
    private static final String exchange = "photo-refine-exchange";
    private final RabbitTemplate rabbitTemplate;

    public void send(String message) {
        rabbitTemplate.convertAndSend(exchange, "reasonable.photo", message);
    }
}

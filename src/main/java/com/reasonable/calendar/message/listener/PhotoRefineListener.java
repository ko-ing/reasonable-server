package com.reasonable.calendar.message.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PhotoRefineListener {

    @RabbitListener(queues = "photo-refine-queue")
    public void receiveMessage(final Message message) {
        System.out.println(message);
    }
}

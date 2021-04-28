package com.reasonable.calendar.message.listener;

import com.reasonable.calendar.domain.photo.PhotoRefineService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class PhotoRefineListener {
    private final PhotoRefineService photoRefineService;

    @RabbitListener(queues = "photo-refine-queue")
    public void receiveMessage(final Message message) {
        photoRefineService.refine(Arrays.toString(message.getBody()));
    }
}

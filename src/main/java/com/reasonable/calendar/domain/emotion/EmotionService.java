package com.reasonable.calendar.domain.emotion;

import com.reasonable.calendar.util.ReflectionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmotionService {
    private final EmotionRepository emotionRepository;

    public Emotion save(Emotion emotion) {
        return emotionRepository.save(emotion);
    }

    public Emotion save(Map<String, Float> fields, UUID photoId) {
        Emotion emotion = Emotion.builder()
            .photoId(photoId)
            .build();

        fields.forEach((key, value) -> ReflectionUtil.set(emotion, key, value));

        return this.save(emotion);
    }
}

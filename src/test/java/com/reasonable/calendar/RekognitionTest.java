package com.reasonable.calendar;

import com.reasonable.calendar.domain.rekognition.RekognitionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@SpringBootTest
public class RekognitionTest {
    @Autowired
    RekognitionService rekognitionService;

    @Test
    public void testRekognitionInvocation() {
        rekognitionService.detectLabels("profile.jpeg");
    }
}

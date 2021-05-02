package com.reasonable.calendar.domain.s3;

import com.reasonable.calendar.controller.photo.PhotoDto;
import com.reasonable.calendar.domain.photo.Photo;
import com.reasonable.calendar.domain.photo.PhotoService;
import com.reasonable.calendar.domain.rekognition.RekognitionService;
import com.reasonable.calendar.message.producer.PhotoRefineProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PhotoS3RekognitionService {
    private final PhotoService photoService;
    private final S3Service s3Service;
    private final RekognitionService rekognitionService;
    private final PhotoRefineProducer photoRefineProducer;

    public String save(PhotoDto dto) {
        String url = "";
        String result = "";
        try {
            url = s3Service.save(dto.getPhoto());
            result = rekognitionService.detectLabels(dto.getPhoto().getOriginalFilename());
            Photo saved = photoService.save(dto, url, result);
            photoRefineProducer.send(saved.getPhotoId().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }
}

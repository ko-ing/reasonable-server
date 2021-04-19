package com.reasonable.calendar.domain.s3;

import com.reasonable.calendar.domain.photo.PhotoDto;
import com.reasonable.calendar.domain.photo.PhotoService;
import com.reasonable.calendar.domain.rekognition.RekognitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PhotoS3RekognitionService {
    private final PhotoService photoService;
    private final S3Service s3Service;
    private final RekognitionService rekognitionService;

    public String save(PhotoDto dto) {
        String url = "";
        String result = "";
        try {
            url = s3Service.save(dto.getPhoto());
            result = rekognitionService.detectLabels(dto.getPhoto().getOriginalFilename());
            photoService.save(dto, url, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }
}

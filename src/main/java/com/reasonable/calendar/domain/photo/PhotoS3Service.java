package com.reasonable.calendar.domain.photo;

import com.reasonable.calendar.domain.s3.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PhotoS3Service {
    private final PhotoService photoService;
    private final S3Service s3Service;

    public void savePhoto(MultipartFile photo) {
        try {
            s3Service.upload(photo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

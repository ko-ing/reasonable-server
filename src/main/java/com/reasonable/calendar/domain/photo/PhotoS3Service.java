package com.reasonable.calendar.domain.photo;

import com.reasonable.calendar.domain.s3.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class PhotoS3Service {
    private final PhotoService photoService;
    private final S3Service s3Service;

    @Transactional
    public void savePhoto(PhotoDto photo) {
        try {
            String url = s3Service.save(photo.getPhoto());
            photoService.save(photo, url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

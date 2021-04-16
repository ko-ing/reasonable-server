package com.reasonable.calendar.domain.photo;

import com.reasonable.calendar.domain.s3.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhotoS3Service {
    private final PhotoService photoService;
    private final S3Service s3Service;

    public String save(PhotoDto dto) {
        String url = "";
        try {
            url = s3Service.save(dto.getPhoto());
            photoService.save(dto, url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }

}

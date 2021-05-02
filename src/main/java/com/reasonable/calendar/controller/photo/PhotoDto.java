package com.reasonable.calendar.controller.photo;

import com.reasonable.calendar.domain.photo.Photo;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@Builder
public class PhotoDto {
    private String url;
    private MultipartFile photo;
    private String userId;
    private LocalDateTime takenAt;
    private String previewUrl;

    public static PhotoDto from(Photo photo) {
        return PhotoDto.builder()
            .previewUrl(photo.getS3Url())
            .takenAt(photo.getTakenAt())
            .build();
    }
}

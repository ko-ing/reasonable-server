package com.reasonable.calendar.domain.photo;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Data
@Builder
public class PhotoDto {
    private String url;
    private MultipartFile photo;
    private String userId;
    private LocalDateTime takenAt;
}

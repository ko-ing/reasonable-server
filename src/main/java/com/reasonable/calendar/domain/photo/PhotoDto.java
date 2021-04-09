package com.reasonable.calendar.domain.photo;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@Builder
public class PhotoDto {
    private String url;
    private Date takenAt;
    private MultipartFile photo;
}

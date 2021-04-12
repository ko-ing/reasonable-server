package com.reasonable.calendar.controller.photo;

import com.reasonable.calendar.domain.photo.PhotoDto;
import com.reasonable.calendar.domain.photo.PhotoS3Service;
import com.reasonable.calendar.domain.photo.PhotoService;
import com.reasonable.calendar.util.LocalDateTimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoS3Service photoS3Service;
    private final PhotoService photoService;

    @PostMapping(value = "/photo")
    public void savePhoto(@RequestParam MultipartFile photo, @RequestParam Long takenAt, Authentication authentication) {
        photoS3Service.save(PhotoDto.builder()
            .takenAt(LocalDateTimeUtil.longToLDT(takenAt))
            .userId(authentication.getName())
            .photo(photo)
            .build());
    }

    @GetMapping(value = "/photo")
    public List<String> findAllPhotoByUser(Authentication authentication) {
        String userId = authentication.getName();
        return photoS3Service.find(userId);
    }

    @GetMapping(value = "/photo/{date}")
    public List<String> findAllPhotoByUserAndDate(@PathVariable Long date, Authentication authentication) {
        String userId = authentication.getName();
        return photoService.find(userId, LocalDateTimeUtil.longToLDT(date));
    }
}

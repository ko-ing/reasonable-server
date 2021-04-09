package com.reasonable.calendar.controller.photo;

import com.reasonable.calendar.domain.photo.PhotoDto;
import com.reasonable.calendar.domain.photo.PhotoS3Service;
import com.reasonable.calendar.domain.photo.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoS3Service photoS3Service;

    @PostMapping(value = "/photo")
    public void savePhoto(@RequestParam MultipartFile photo, @RequestParam Date takenAt) {
        photoS3Service.savePhoto(PhotoDto.builder()
            .takenAt(takenAt)
            .photo(photo)
            .build());
    }

    @GetMapping(value = "/photo")
    public void findAllPhotoByUser(Authentication authentication) {
        String userId = authentication.getName();
    }
}

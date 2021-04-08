package com.reasonable.calendar.controller.photo;

import com.reasonable.calendar.domain.photo.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoService photoService;

    @PostMapping(value = "/photo")
    public void savePhoto(@RequestParam MultipartFile photo) {
        photoService.savePhoto();
    }
}

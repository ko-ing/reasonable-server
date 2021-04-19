package com.reasonable.calendar.controller.photo;

import com.reasonable.calendar.domain.photo.PhotoDto;
import com.reasonable.calendar.domain.s3.PhotoS3RekognitionService;
import com.reasonable.calendar.domain.photo.PhotoService;
import com.reasonable.calendar.util.LocalDateTimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoS3RekognitionService photoS3RekognitionService;
    private final PhotoService photoService;

    @PostMapping(value = "/photo")
    public String savePhoto(@RequestParam MultipartFile photo, @RequestParam Long takenAt, Authentication authentication) {
        return photoS3RekognitionService.save(PhotoDto.builder()
            .takenAt(LocalDateTimeUtil.longToLDT(takenAt))
            .userId(authentication.getName())
            .photo(photo)
            .build());
    }

    @GetMapping(value = "/photo")
    public List<String> findAllPhotoByUser(Authentication authentication, @RequestParam Integer page, @RequestParam Integer size) {
        String userId = authentication.getName();
        Pageable paging = PageRequest.of(page, size);
        return photoService.findPhotoUrls(userId, paging);
    }

    @GetMapping(value = "/photo/{date}")
    public List<String> findAllPhotoByUserAndDate(@PathVariable Long date, Authentication authentication) {
        String userId = authentication.getName();
        return photoService.find(userId, LocalDateTimeUtil.longToLDT(date));
    }
}

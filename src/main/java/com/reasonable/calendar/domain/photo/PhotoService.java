package com.reasonable.calendar.domain.photo;

import com.reasonable.calendar.controller.photo.PhotoDto;
import com.reasonable.calendar.exception.ReasonableException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PhotoService {
    private final PhotoRepository photoRepository;

    public Photo save(Photo photo) {
        return photoRepository.save(photo);
    }

    public Photo save(PhotoDto dto, String url, String analyzed) {
        return this.save(Photo.builder()
            .s3Url(url)
            .takenAt(dto.getTakenAt())
            .userId(UUID.fromString(dto.getUserId()))
            .analyzedRaw(analyzed)
            .build());
    }

    public Photo findByPhotoId(String photoId) {
        return photoRepository.findById(UUID.fromString(photoId)).orElseThrow(() -> new ReasonableException("No such photo"));
    }

    public List<Photo> findByUserId(String userId) {
        return photoRepository.findAllByUserId(UUID.fromString(userId));
    }

    public List<Photo> findByUserId(String userId, Pageable page) {
        return photoRepository.findAllByUserId(UUID.fromString(userId), page);
    }

    public List<PhotoDto> findPhotosByUserId(String userId, Pageable page) {
        return this.findByUserId(userId, page).stream().map(PhotoDto::from).collect(Collectors.toList());
    }

    public List<String> findByUserIdAndDate(String userId, LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        List<Photo> photos = this.findByUserId(userId);
        return photos.stream()
            .filter(p -> date.format(formatter).equals(p.getTakenAt().format(formatter)))
            .map(Photo::getS3Url)
            .collect(Collectors.toList());
    }
}

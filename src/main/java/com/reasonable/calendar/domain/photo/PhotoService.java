package com.reasonable.calendar.domain.photo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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

    public Photo save(PhotoDto dto, String url) {
        return this.save(Photo.builder()
            .s3Url(url)
            .takenAt(dto.getTakenAt())
            .userId(UUID.fromString(dto.getUserId()))
            .build());
    }

    public List<Photo> find(UUID userId) {
        return photoRepository.findAllByUserId(userId);
    }

    public List<Photo> find(String userId) {
        return this.find(UUID.fromString(userId));
    }

    public List<String> find(String userId, LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        List<Photo> photos = this.find(userId);
        return photos.stream()
            .filter(p -> date.format(formatter).equals(p.getTakenAt().format(formatter)))
            .map(Photo::getS3Url)
            .collect(Collectors.toList());
    }
}

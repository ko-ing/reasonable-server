package com.reasonable.calendar.domain.photo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PhotoService {
    private final PhotoRepository photoRepository;

    public Photo save(Photo photo) {
        return photoRepository.save(photo);
    }

    public Photo save(PhotoDto vo, String url) {
        return this.save(Photo.builder()
            .s3Url(url)
            .takenAt(vo.getTakenAt())
            .build());
    }

    public List<Photo> find(UUID userId) {
        return photoRepository.findAllByUserId(userId);
    }

    public List<Photo> find(String userId) {
        return this.find(UUID.fromString(userId));
    }
}

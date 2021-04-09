package com.reasonable.calendar.domain.photo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}

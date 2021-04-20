package com.reasonable.calendar.domain.photo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PhotoRepository extends PagingAndSortingRepository<Photo, UUID> {
    List<Photo> findAllByUserId(UUID userId);
    List<Photo> findAllByUserId(UUID userId, Pageable pageable);
}

package com.reasonable.calendar.domain.photo;

import com.reasonable.calendar.domain.auth.Authority;
import com.reasonable.calendar.domain.auth.AuthorityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, UUID> {
    List<Photo> findAllByUserId(UUID userId);
}

package com.reasonable.calendar.domain.emotion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmotionRepository extends JpaRepository<Emotion, UUID> {

}

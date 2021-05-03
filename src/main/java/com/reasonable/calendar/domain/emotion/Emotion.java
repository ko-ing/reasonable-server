package com.reasonable.calendar.domain.emotion;

import com.reasonable.calendar.domain.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "emotions", schema = "reasonable_schema")
@NoArgsConstructor
@AllArgsConstructor
public class Emotion extends BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "emotion_id")
    private UUID emotionId;

    @Column(name = "photo_id")
    private UUID photoId;

    @Column(name = "person_id")
    private UUID personId;

    @Column(name = "bound_left")
    private Float boundLeft;

    @Column(name = "bound_top")
    private Float boundTop;

    @Column(name = "bound_width")
    private Float boundWidth;

    @Column(name = "bound_height")
    private Float boundHeight;

    @Column(name = "calm")
    private Float calm;

    @Column(name = "sad")
    private Float sad;

    @Column(name = "angry")
    private Float angry;

    @Column(name = "happy")
    private Float happy;

    @Column(name = "confused")
    private Float confused;

    @Column(name = "surprised")
    private Float surprised;

    @Column(name = "disgusted")
    private Float disgusted;

    @Column(name = "fear")
    private Float fear;
}

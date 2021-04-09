package com.reasonable.calendar.domain.photo;

import com.reasonable.calendar.domain.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "photos", schema = "reasonable_schema")
@NoArgsConstructor
@AllArgsConstructor
public class Photo extends BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "photo_id")
    private UUID photoId;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "s3_url")
    private String s3Url;

    @Column(name = "analyzed_raw")
    private String analyzedRaw;

    @Column(name = "photo_taken_at")
    private Date takenAt;
}

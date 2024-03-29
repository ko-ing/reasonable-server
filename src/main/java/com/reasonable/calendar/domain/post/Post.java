package com.reasonable.calendar.domain.post;

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
@Table(name = "posts", schema = "reasonable_schema")
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "post_id")
    private UUID post_id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "text")
    private String text;

    @Column(name = "tags")
    private String tags;
}

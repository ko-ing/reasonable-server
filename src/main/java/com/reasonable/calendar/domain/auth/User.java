package com.reasonable.calendar.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "users", schema = "reasonable_schema")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "user_account_id")
    private String userAccountId;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)//Lazy는 transaction으로묶어야할걸
    @JoinColumn(name = "user_id")
    private Set<Authority> authorities;
}

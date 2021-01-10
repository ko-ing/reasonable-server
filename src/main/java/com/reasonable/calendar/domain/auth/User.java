package com.reasonable.calendar.domain.auth;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "identification")
    private String accountId;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;
}

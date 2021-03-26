package com.reasonable.calendar.domain.auth;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class AuthorityId implements Serializable {
    private UUID userId;
    private AuthorityName authority;
}

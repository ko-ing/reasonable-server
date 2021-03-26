package com.reasonable.calendar.controller.auth;

import com.reasonable.calendar.domain.auth.Authority;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class AuthTokenDto {
    private String userAccountId;
    private Set<String> authorities;
    private String sessionId;
}

package com.reasonable.calendar.controller.auth;

import com.reasonable.calendar.domain.auth.Authority;
import com.reasonable.calendar.domain.auth.User;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class UserDto {
    private String userAccountId;
    private Set<String> authorities;

    public static UserDto from(User user) {
        return UserDto.builder()
            .userAccountId(user.getUserAccountId())
            .authorities(user.getAuthorities().stream().map(Authority::getAuthority).collect(Collectors.toSet()))
            .build();
    }
}

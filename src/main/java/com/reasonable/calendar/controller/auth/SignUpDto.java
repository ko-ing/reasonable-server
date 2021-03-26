package com.reasonable.calendar.controller.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
    private String userAccountId;
    private String userName;
    private String password;
    private String email;
}

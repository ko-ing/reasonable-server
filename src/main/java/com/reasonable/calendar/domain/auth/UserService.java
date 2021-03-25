package com.reasonable.calendar.domain.auth;

import com.reasonable.calendar.controller.auth.SignInDto;
import com.reasonable.calendar.controller.auth.SignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void userSignUp(SignUpDto dto) {
        userRepository.save(User.builder()
            .name(dto.getUserName())
            .email(dto.getEmail())
            .password(dto.getPassword())
            .userAccountId(dto.getUserId())
            .build());
    }

    public void userSignIn(SignInDto dto) {

    }

}

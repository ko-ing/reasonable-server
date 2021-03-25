package com.reasonable.calendar.controller.auth;

import com.reasonable.calendar.domain.auth.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping(value = "/auth/signUp")
    private void signUp(@RequestBody SignUpDto dto) {
        userService.userSignUp(dto);
    }

    @PostMapping(value= "/auth/signIn")
    private String signIn(@RequestBody SignInDto dto) {
        return "테스트";
    }
}

package com.reasonable.calendar.controller.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @PostMapping(value = "auth/")
    private void signUp() {

    }
}

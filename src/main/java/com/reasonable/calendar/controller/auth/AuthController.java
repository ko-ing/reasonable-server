package com.reasonable.calendar.controller.auth;

import com.reasonable.calendar.domain.auth.UserAuthorityService;
import com.reasonable.calendar.domain.auth.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final UserAuthorityService userAuthorityService;

    @PostMapping(value = "/auth/signUp")
    public void signUp(@RequestBody SignUpDto dto) {
        // fixme: validate before inserting
        userAuthorityService.checkAndSaveUser(dto);
    }

    @PostMapping(value = "/auth/signOut")
    public void signOut(@RequestBody SignOutDto dto) {
        //fixme: validate before deleting
        userService.delete(dto);
    }

}

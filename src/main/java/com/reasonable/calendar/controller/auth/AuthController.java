package com.reasonable.calendar.controller.auth;

import com.reasonable.calendar.domain.auth.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthenticationProvider authenticationProvider;

    @PostMapping(value = "/auth/signUp")
    public void signUp(@RequestBody SignUpDto dto) {
        userService.add(dto);
    }

//    @PostMapping(value= "/auth/signIn")
//    public AuthTokenDto signIn(@RequestBody SignInDto dto, HttpSession session) {
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dto.getUserAccountId(), dto.getPassword());
//        Authentication authentication = authenticationProvider.authenticate(token);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
//
//        UserDto user = UserDto.from(userService.findByAccountId(dto.getUserAccountId()));
//        return AuthTokenDto.builder()
//            .userAccountId(user.getUserAccountId())
//            .authorities(user.getAuthorities())
//            .sessionId(session.getId())
//            .build();
//    }
}

package com.reasonable.calendar.domain.auth;

import com.reasonable.calendar.controller.auth.SignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserAuthorityService {
    private final AuthorityRepository authorityRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityService authorityService;

    public Set<Authority> findAuthorityByUser(User user) {
        return authorityRepository.findAllByUserId(user.getUserId());
    }

    @Transactional
    public void checkAndSaveUser(SignUpDto dto) {
        Set<Authority> auths = new HashSet<>();

        Boolean exists = userService.checkExistence(dto.getUserAccountId());
        if (exists) {

        }

        User user = User.builder()
            .name(dto.getUserName())
            .email(dto.getEmail())
            .password(passwordEncoder.encode((dto.getPassword())))
            .userAccountId(dto.getUserAccountId())
            .build();

        auths.add(Authority.builder()
            .userId(user.getUserId())
            .authority(AuthorityName.USER)
            .build());

        user.setAuthorities(auths);

        userService.save(user);
    }
}

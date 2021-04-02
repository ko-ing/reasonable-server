package com.reasonable.calendar.domain.auth;

import com.reasonable.calendar.controller.auth.SignOutDto;
import com.reasonable.calendar.controller.auth.SignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User save(SignUpDto dto) {
        return this.save(User.builder()
            .name(dto.getUserName())
            .email(dto.getEmail())
            .password(passwordEncoder.encode((dto.getPassword())))
            .userAccountId(dto.getUserAccountId())
            .build());
    }

    public boolean checkExistence(String accountId) {
        return userRepository.existsByUserAccountId(accountId);
    }

    public User findByAccountId(String accountId) {
        return userRepository.findByUserAccountId(accountId);
    }

    public void update() {

    }

    public void delete(SignOutDto dto) {

    }
}

package com.reasonable.calendar.domain.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserAuthorityService {
    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;

    public Set<Authority> findAuthorityByUser(User user) {
        return authorityRepository.findAllByUserId(user.getUserId());
    }
}

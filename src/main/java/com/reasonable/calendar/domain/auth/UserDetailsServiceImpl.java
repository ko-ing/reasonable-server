package com.reasonable.calendar.domain.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserAuthorityService userAuthorityService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String accountId) throws UsernameNotFoundException {
        User user = Optional.ofNullable(
            userRepository.findByUserAccountId(accountId)
        ).orElseThrow(
            () -> new UsernameNotFoundException("no user name: " + accountId)
        );
        return UserDetailsImpl.from(user);
    }
}
package com.reasonable.calendar.domain.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    @Override
    public UserDetails loadUserByUsername(String accountId) throws UsernameNotFoundException {
        User user = Optional.ofNullable(
            userRepository.findByUserAccountId(accountId)
        ).orElseThrow(
            () -> new UsernameNotFoundException("no user name: " + accountId)
        );
        return UserDetailsImpl.from(user);
    }
}
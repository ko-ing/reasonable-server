package com.reasonable.calendar.domain.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorityService {
    private final AuthorityRepository authorityRepository;

    public void add(Authority authority) {
        authorityRepository.save(authority);
    }

//    public Authority find() {
//
//    }

    public void update() {

    }

    public void delete() {

    }

}

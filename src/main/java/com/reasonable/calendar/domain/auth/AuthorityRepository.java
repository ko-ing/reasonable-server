package com.reasonable.calendar.domain.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, AuthorityId> {
    Set<Authority> findAllByUserId(UUID userID);
}

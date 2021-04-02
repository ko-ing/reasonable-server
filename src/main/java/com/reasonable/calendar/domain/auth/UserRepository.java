package com.reasonable.calendar.domain.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUserAccountId(String userAccountId);
    Boolean existsByUserAccountId(String userAccountId);
}

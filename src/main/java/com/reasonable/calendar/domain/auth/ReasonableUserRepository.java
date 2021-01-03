package com.reasonable.calendar.domain.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReasonableUserRepository extends JpaRepository<ReasonableUser, Long> {
}

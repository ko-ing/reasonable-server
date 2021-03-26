package com.reasonable.calendar.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "authority", schema = "reasonable_schema")
@NoArgsConstructor
@AllArgsConstructor
@IdClass(AuthorityId.class)
public class Authority implements GrantedAuthority {
    @Id
    @Column(name = "user_id")
    private UUID userId;

    @Id
    @Column(name = "authority")
    @Enumerated(EnumType.STRING)
    private AuthorityName authority;

    @Override
    public String getAuthority() {
        return authority.name();
    }
}

package com.jwtTest.jwtAuth.repository;

import com.jwtTest.jwtAuth.models.ERole;
import com.jwtTest.jwtAuth.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

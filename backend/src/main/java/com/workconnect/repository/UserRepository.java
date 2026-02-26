package com.workconnect.repository;

import com.workconnect.model.Role;
import com.workconnect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(Role role);
}

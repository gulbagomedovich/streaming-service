package com.gulbagomedovich.streamingservice.repository;

import com.gulbagomedovich.streamingservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getByUsername(String username);

    User getByEmail(String email);
}

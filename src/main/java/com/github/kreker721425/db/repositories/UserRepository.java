package com.github.kreker721425.db.repositories;

import com.github.kreker721425.db.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}

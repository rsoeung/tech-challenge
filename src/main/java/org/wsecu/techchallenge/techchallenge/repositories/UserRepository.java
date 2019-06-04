package org.wsecu.techchallenge.techchallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wsecu.techchallenge.techchallenge.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}

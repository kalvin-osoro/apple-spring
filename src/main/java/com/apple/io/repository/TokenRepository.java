package com.apple.io.repository;

import com.apple.io.model.AuthenticationToken;
import com.apple.io.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findByUser(User user);

    AuthenticationToken findByToken(String token);
}

package com.example.api_conserto_carro.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface RepositoryUser extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}

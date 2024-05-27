package me.fixeddev.basededatos.repositories;

import me.fixeddev.basededatos.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
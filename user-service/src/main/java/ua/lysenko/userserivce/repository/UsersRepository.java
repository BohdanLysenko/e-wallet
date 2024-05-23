package ua.lysenko.userserivce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lysenko.userserivce.entity.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
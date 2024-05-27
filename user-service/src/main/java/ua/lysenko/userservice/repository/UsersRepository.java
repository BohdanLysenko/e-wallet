package ua.lysenko.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ua.lysenko.userservice.entity.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);

    @Modifying
    @Query(value = "update users set is_transaction_blocked = false where is_transaction_blocked = true",
            nativeQuery = true)
    void unblockAllBlockedUsers();
}
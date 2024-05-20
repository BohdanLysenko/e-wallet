package ua.lysenko.banking.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lysenko.banking.entity.Wallet;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByUserID(Long userID);
}
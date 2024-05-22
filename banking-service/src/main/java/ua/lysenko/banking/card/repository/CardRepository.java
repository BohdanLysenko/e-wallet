package ua.lysenko.banking.card.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lysenko.banking.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findByWalletId(Long walletId);
    Optional<Card> findByCardNumberAndActiveIsTrue(String cardNumber);
    Optional<Card> findByIdAndActiveIsTrue(Long id);

}
package ua.lysenko.banking.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.lysenko.banking.entity.Card;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findByWalletId(Long walletId);
    Optional<Card> findByCardNumberAndActiveIsTrue(String cardNumber);
    @Query("SELECT c.id FROM Card c WHERE c.cardNumber = :cardNumber AND c.active = true")
    Optional<Long> findIdByCardNumberAndActiveIsTrue(@Param("cardNumber") String cardNumber);
    Optional<Card> findByIdAndActiveIsTrue(Long id);

}
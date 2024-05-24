package ua.lysenko.banking.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.lysenko.banking.entity.Card;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findByCardNumberAndActiveIsTrue(String cardNumber);

    @Query("SELECT c.id FROM Card c WHERE c.cardNumber = :cardNumber AND c.active = true")
    Optional<Long> findIdByCardNumberAndActiveIsTrue(@Param("cardNumber") String cardNumber);

    Optional<Card> findByIdAndActiveIsTrue(Long id);

    @Query(value = "select * from card w where w.active = true and w.wallet_id = :walletId", nativeQuery = true)
    List<Card> findAllByWalletAndActiveIsTrue(Long walletId);

    @Modifying
    @Query(value = "UPDATE card SET active = false WHERE wallet_id = :walletId", nativeQuery = true)
    void deactivateAllCards(@Param("walletId") Long walletId);
}
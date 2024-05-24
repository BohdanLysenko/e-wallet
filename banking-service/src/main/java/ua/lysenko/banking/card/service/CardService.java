package ua.lysenko.banking.card.service;


import ua.lysenko.banking.card.DTO.CardDTO;
import ua.lysenko.banking.entity.Card;
import ua.lysenko.banking.entity.Wallet;

import java.math.BigDecimal;
import java.util.List;

public interface CardService {
    CardDTO createCard(String token);

    CardDTO getByCardNumber(String cardNumber);

    Card findByCardNumber(String cardNumber);

    Long getIdByCardNumber(String cardNumber);

    CardDTO getById(Long id, String token);

    List<CardDTO> getAllCardsByWalletId(Wallet wallet);

    boolean deposit(BigDecimal amount, Long cardId);

    boolean withdraw(BigDecimal amount, Long cardId);

    boolean isBalanceExceeded(BigDecimal amount, Long cardId);
}

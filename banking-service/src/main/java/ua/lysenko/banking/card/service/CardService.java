package ua.lysenko.banking.card.service;


import ua.lysenko.banking.card.DTO.CardDTO;
import ua.lysenko.banking.card.models.CreateCardResponseModel;
import ua.lysenko.banking.entity.Card;

import java.math.BigDecimal;

public interface CardService {
    CreateCardResponseModel createCard(String token);
    CardDTO createCardByUserId(Long userID);

    Card getByCardNumber(String cardNumber);

    Long getIdByCardNumber(String cardNumber);

    Card getById(Long id);

    boolean deposit(BigDecimal amount, Long cardId);
    boolean withdraw(BigDecimal amount, Long cardId);

    boolean isBalanceExceeded(BigDecimal amount, Long cardId);
}

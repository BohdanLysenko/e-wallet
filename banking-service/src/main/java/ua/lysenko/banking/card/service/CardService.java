package ua.lysenko.banking.card.service;


import ua.lysenko.banking.card.DTO.CardDTO;
import ua.lysenko.banking.card.models.CreateCardResponseModel;
import ua.lysenko.banking.entity.Card;

public interface CardService {
    CreateCardResponseModel createCard(String token);
    CardDTO createCardByUserId(Long userID);

    Card getByCardNumber(String cardNumber);

    Card getById(Long id);
}

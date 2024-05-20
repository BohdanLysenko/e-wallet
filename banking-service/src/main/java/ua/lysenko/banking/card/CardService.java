package ua.lysenko.banking.card;


import ua.lysenko.banking.card.DTO.CardDTO;
import ua.lysenko.banking.card.models.CreateCardResponseModel;

public interface CardService {
    CreateCardResponseModel createCard(String token);
    CardDTO createCardByUserId(Long userID);
}

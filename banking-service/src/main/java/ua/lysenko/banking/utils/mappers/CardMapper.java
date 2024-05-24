package ua.lysenko.banking.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.card.DTO.CardDTO;
import ua.lysenko.banking.card.models.CardResponseModel;
import ua.lysenko.banking.entity.Card;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

    CardMapper mapper = Mappers.getMapper(CardMapper.class);

    CardResponseModel toCardResponseModel(CardDTO cardDTO);

    CardDTO toCardDto(Card save);

    List<CardDTO> cardsToCardDTOs(List<Card> cards);

    Card toCard(CardDTO cardDTO);
}
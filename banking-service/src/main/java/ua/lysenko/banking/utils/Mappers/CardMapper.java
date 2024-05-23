package ua.lysenko.banking.utils.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.card.DTO.CardDTO;
import ua.lysenko.banking.card.models.CreateCardResponseModel;
import ua.lysenko.banking.entity.Card;

@Mapper(componentModel = "spring")
public interface CardMapper {

    CardMapper mapper = Mappers.getMapper(CardMapper.class);

    CreateCardResponseModel toCreateCardResponseModel(CardDTO cardDTO);

    CardDTO toCardDto(Card save);
}
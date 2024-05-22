package ua.lysenko.banking.utils.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.card.DTO.CardDTO;
import ua.lysenko.banking.card.models.CreateCardResponseModel;
import ua.lysenko.banking.entity.Card;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;

@Mapper(componentModel = "spring")
public interface CardMapper {

    CardMapper mapper = Mappers.getMapper(CardMapper.class);

    CreateCardResponseModel toCreateCardResponseModel(CardDTO cardDTO);

    CardDTO toCardDto(Card save);
}
package ua.lysenko.banking.utils.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.models.CreateTransactionRequestModel;
import ua.lysenko.banking.transaction.models.TransactionResponseModel;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;

@Mapper(componentModel = "spring")
public interface TransactionContextMapper {

    TransactionContextMapper mapper = Mappers.getMapper(TransactionContextMapper.class);

    @Mapping(target = "successful", source = "valid")
    TransactionDTO updateTransactionDTO(TransactionValidationResult result, @MappingTarget TransactionDTO transactionDTO);

    TransactionResponseModel toTransactionResponseModel(TransactionDTO processTransaction);

    TransactionDTO toTransactionDTO(CreateTransactionRequestModel request);
}
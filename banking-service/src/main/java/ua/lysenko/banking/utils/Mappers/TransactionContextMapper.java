package ua.lysenko.banking.utils.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.entity.Transaction;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.models.*;

@Mapper(componentModel = "spring")
public interface TransactionContextMapper {

    TransactionContextMapper mapper = Mappers.getMapper(TransactionContextMapper.class);

    @Mapping(target = "successful", source = "valid")
    TransactionDTO updateTransactionDTO(TransactionValidationResult result, @MappingTarget TransactionDTO transactionDTO);

    TransactionResponseModel toTransactionResponseModel(TransactionDTO processTransaction);
}
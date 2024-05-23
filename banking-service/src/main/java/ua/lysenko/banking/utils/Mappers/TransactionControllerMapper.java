package ua.lysenko.banking.utils.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.models.*;

@Mapper(componentModel = "spring")
public interface TransactionControllerMapper {

    TransactionControllerMapper mapper = Mappers.getMapper(TransactionControllerMapper.class);

    TransactionDTO toTransactionDTO(CreateTransactionRequestModel request);
    TransactionDTO toTransactionDTO(CreateTransferTransactionRequestModel request);
    TransactionDTO toTransactionDTO(CreatePaymentTransactionRequestModel request);
}
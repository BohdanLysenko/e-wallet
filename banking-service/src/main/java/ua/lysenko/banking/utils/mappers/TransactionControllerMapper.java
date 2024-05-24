package ua.lysenko.banking.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.models.CreatePaymentTransactionRequestModel;
import ua.lysenko.banking.transaction.models.CreateTransactionRequestModel;
import ua.lysenko.banking.transaction.models.CreateTransferTransactionRequestModel;

@Mapper(componentModel = "spring")
public interface TransactionControllerMapper {

    TransactionControllerMapper mapper = Mappers.getMapper(TransactionControllerMapper.class);

    TransactionDTO toTransactionDTO(CreateTransactionRequestModel request);
    TransactionDTO toTransactionDTO(CreateTransferTransactionRequestModel request);
    TransactionDTO toTransactionDTO(CreatePaymentTransactionRequestModel request);
}
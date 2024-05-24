package ua.lysenko.banking.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.entity.PaymentTransaction;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;

@Mapper(componentModel = "spring")
public interface PaymentTransactionMapper {
    PaymentTransactionMapper mapper = Mappers.getMapper(PaymentTransactionMapper.class);
    TransactionDTO updateTransactionDTO(PaymentTransaction result, @MappingTarget TransactionDTO transactionDTO);
}
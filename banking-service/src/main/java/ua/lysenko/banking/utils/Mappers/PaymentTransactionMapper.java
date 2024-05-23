package ua.lysenko.banking.utils.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.entity.PaymentTransaction;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;

@Mapper(componentModel = "spring")
public interface PaymentTransactionMapper {
    PaymentTransactionMapper mapper = Mappers.getMapper(PaymentTransactionMapper.class);

    TransactionDTO toTransactionDTO(PaymentTransaction paymentTransaction);
}
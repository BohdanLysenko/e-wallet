package ua.lysenko.banking.utils.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.entity.DepositTransaction;
import ua.lysenko.banking.entity.WithdrawalTransaction;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;

@Mapper(componentModel = "spring")
public interface DepositTransactionMapper {
    DepositTransactionMapper mapper = Mappers.getMapper(DepositTransactionMapper.class);

    TransactionDTO toTransactionDTO(DepositTransaction depositTransaction);
}
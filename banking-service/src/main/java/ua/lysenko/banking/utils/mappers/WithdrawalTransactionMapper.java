package ua.lysenko.banking.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.entity.WithdrawalTransaction;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;

@Mapper(componentModel = "spring")
public interface WithdrawalTransactionMapper {
    WithdrawalTransactionMapper mapper = Mappers.getMapper(WithdrawalTransactionMapper.class);
    TransactionDTO updateTransactionDTO(WithdrawalTransaction result, @MappingTarget TransactionDTO transactionDTO);
}
package ua.lysenko.banking.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.entity.DepositTransaction;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;

@Mapper(componentModel = "spring")
public interface DepositTransactionMapper {
    DepositTransactionMapper mapper = Mappers.getMapper(DepositTransactionMapper.class);
    TransactionDTO updateTransactionDTO(DepositTransaction result, @MappingTarget TransactionDTO transactionDTO);
}
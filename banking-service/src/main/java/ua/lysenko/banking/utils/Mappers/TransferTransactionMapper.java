package ua.lysenko.banking.utils.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.entity.DepositTransaction;
import ua.lysenko.banking.entity.TransferTransaction;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;

@Mapper(componentModel = "spring")
public interface TransferTransactionMapper {
    TransferTransactionMapper mapper = Mappers.getMapper(TransferTransactionMapper.class);

    TransactionDTO toTransactionDTO(TransferTransaction depositTransaction);
}
package ua.lysenko.banking.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.entity.TransferTransaction;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;

@Mapper(componentModel = "spring")
public interface TransferTransactionMapper {
    TransferTransactionMapper mapper = Mappers.getMapper(TransferTransactionMapper.class);
    @Mapping(target = "destinationCardNumber", ignore = true)
    TransactionDTO updateTransactionDTO(TransferTransaction result, @MappingTarget TransactionDTO transactionDTO);
}
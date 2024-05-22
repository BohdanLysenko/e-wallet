package ua.lysenko.banking.utils.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;

@Mapper(componentModel = "spring")
public interface WalletTransactionMapper {

    WalletTransactionMapper mapper = Mappers.getMapper(WalletTransactionMapper.class);



}
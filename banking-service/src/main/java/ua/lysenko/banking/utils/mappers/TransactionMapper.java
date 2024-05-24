package ua.lysenko.banking.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.entity.Transaction;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.models.TransactionResponseModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionMapper mapper = Mappers.getMapper(TransactionMapper.class);

    TransactionDTO updateTransactionDTO(Transaction result, @MappingTarget TransactionDTO transactionDTO);

    List<TransactionDTO> transactionsToTransactionsDTO(List<Transaction> transactions);
    List<TransactionResponseModel> transactionsDTOToTransactionsResponseModel(List<TransactionDTO> transactions);

    TransactionDTO toTransactionDTO(Transaction transaction);
}
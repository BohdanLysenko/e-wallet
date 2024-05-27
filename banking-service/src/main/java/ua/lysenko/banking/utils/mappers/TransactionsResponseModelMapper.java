package ua.lysenko.banking.utils.mappers;

import org.springframework.stereotype.Component;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.models.TransactionResponseModel;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionsResponseModelMapper {

    public List<TransactionResponseModel> toTransactionsResponseModel(List<TransactionDTO> transactionsDTO) {
        List<TransactionResponseModel> transactions = new ArrayList<>();
        for (TransactionDTO transactionDTO : transactionsDTO) {
            TransactionResponseModel responseModel = new TransactionResponseModel();
            responseModel.setTransactionType(transactionDTO.getTransactionType().toString());
            responseModel.setTransactionUUID(transactionDTO.getTransactionUUID());
            responseModel.setAmount(transactionDTO.getAmount());
            responseModel.setCreatedDate(transactionDTO.getCreatedDate());
            responseModel.setSuccessful(transactionDTO.isSuccessful());
            responseModel.setCreatedDate(transactionDTO.getCreatedDate());
            responseModel.setErrorMsgs(transactionDTO.getErrorMsgs());
            transactions.add(responseModel);
        }
        return transactions;
    }
}

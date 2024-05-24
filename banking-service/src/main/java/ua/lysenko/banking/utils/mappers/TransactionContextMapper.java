package ua.lysenko.banking.utils.mappers;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.models.TransactionResponseModel;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionContextMapper {

    TransactionContextMapper mapper = Mappers.getMapper(TransactionContextMapper.class);

    @Mapping(target = "successful", source = "valid")
    TransactionDTO updateTransactionDTO(TransactionValidationResult result, @MappingTarget TransactionDTO transactionDTO);

    @Mapping(source = "errorMsgs", target = "errorMsgs", qualifiedByName = "mapErrorMsg")
    TransactionResponseModel toTransactionResponseModel(TransactionDTO processTransaction,
                                                        @MappingTarget TransactionResponseModel response);


    @Named("mapErrorMsg")
    static List<String> mapErrorMsg(List<String> errorMsg) {
        return (errorMsg == null || errorMsg.isEmpty()) ? null : errorMsg;
    }
}

package ua.lysenko.banking.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import ua.lysenko.banking.entity.DepositTransaction;
import ua.lysenko.banking.entity.Wallet;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;
import ua.lysenko.banking.transaction.models.TransactionValidationResult;
import ua.lysenko.banking.wallet.dto.WalletDTO;

@Component
public class MapperUtils {

    private static final ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        typeMapWalletWalletDTO();
        typeMapDepositTransactionTransactionDTO();
        typeMapTransactionValidationResultTransactionDTO();
    }

    public static <T, U> U map(T source, Class<U> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    private static void typeMapWalletWalletDTO() {
        modelMapper.typeMap(Wallet.class, WalletDTO.class)
                .addMappings(mapper -> mapper.using(Converters.UUID_TO_STRING_CONVERTER)
                        .map(Wallet::getWalletNumber, WalletDTO::setWalletNumber));
    }

    private static void typeMapDepositTransactionTransactionDTO() {
        modelMapper.typeMap(DepositTransaction.class, TransactionDTO.class)
                .addMappings(mapper -> mapper.using(Converters.UUID_TO_STRING_CONVERTER)
                        .map(DepositTransaction::getTransactionUUID, TransactionDTO::setTransactionUUID));
    }

    private static void typeMapTransactionValidationResultTransactionDTO() {
        modelMapper.typeMap(TransactionValidationResult.class, TransactionDTO.class)
                .addMapping(TransactionValidationResult::isValid, TransactionDTO::setSuccessful);
    }
}
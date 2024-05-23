package ua.lysenko.banking.transaction.conf;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.lysenko.banking.transaction.enums.TransactionType;
import ua.lysenko.banking.transaction.service.TransactionService;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Configuration
@AllArgsConstructor
public class TransactionServiceConfig {
    private final List<TransactionService> transactionStrategies;


    @Bean
    public Map<TransactionType, TransactionService> processTransactionByType() {
        Map<TransactionType, TransactionService> transactionByType = new EnumMap<>(TransactionType.class);
        transactionStrategies.forEach(transactionStrategy ->
                transactionByType.put(transactionStrategy.getTransactionType(), transactionStrategy));
        return transactionByType;
    }
}
package ua.lysenko.banking.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lysenko.banking.entity.DepositTransaction;

public interface DepositTransactionRepository extends JpaRepository<DepositTransaction, Long> {
}
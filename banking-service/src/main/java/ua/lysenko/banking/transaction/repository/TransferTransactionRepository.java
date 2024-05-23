package ua.lysenko.banking.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lysenko.banking.entity.TransferTransaction;

public interface TransferTransactionRepository extends JpaRepository<TransferTransaction, Long> {

}
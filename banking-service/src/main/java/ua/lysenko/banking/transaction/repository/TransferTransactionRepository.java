package ua.lysenko.banking.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.lysenko.banking.entity.TransferTransaction;
import ua.lysenko.banking.entity.WithdrawalTransaction;

import java.math.BigDecimal;
import java.util.Optional;

public interface TransferTransactionRepository extends JpaRepository<TransferTransaction, Long> {

}
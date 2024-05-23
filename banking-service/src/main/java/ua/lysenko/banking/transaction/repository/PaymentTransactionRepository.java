package ua.lysenko.banking.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lysenko.banking.entity.PaymentTransaction;

public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long> {

}
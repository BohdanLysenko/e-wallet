package ua.lysenko.banking.transaction.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.lysenko.banking.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "select count(1)\n" +
            "from transaction t\n" +
            "         join card c on t.card_id = c.id\n" +
            "         join wallet w on c.wallet_id = w.id\n" +
            "where w.user_id =:userId\n" +
            "  and t.created_date > NOW() - interval '1 hour'", nativeQuery = true)
    int countTransactionForLastHourByUserId(@Param("userId") Long userId);

    Page<Transaction> findAllByCardIdOrderByCreatedDateDesc(Long cardId, Pageable pageable);
}
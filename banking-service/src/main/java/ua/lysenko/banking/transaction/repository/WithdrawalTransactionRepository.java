package ua.lysenko.banking.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.lysenko.banking.entity.WithdrawalTransaction;

import java.math.BigDecimal;
import java.util.Optional;

public interface WithdrawalTransactionRepository extends JpaRepository<WithdrawalTransaction, Long> {

    //select sum(t.amount)
    //from transaction t
    //where t.card_id = :cardId
    //  and t.transaction_type = 'WITHDRAWAL'
    //  and t.created_date > NOW() - interval '1 day'
    //group by card_id;

    @Query(value = "select sum(t.amount)\n" +
            "from transaction t\n" +
            "where t.card_id = :cardId\n" +
            "  and t.created_date > NOW() - interval '1 day'\n" +
            "  and t.is_successful is true\n" +
            "  and t.transaction_type = 'WITHDRAWAL'\n" +
            "group by card_id", nativeQuery = true)
    Optional<BigDecimal> selectDailyWithdrawalAmountByCardId(@Param("cardId") Long cardId);
}
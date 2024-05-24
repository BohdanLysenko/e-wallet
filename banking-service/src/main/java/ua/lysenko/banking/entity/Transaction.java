package ua.lysenko.banking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;
import ua.lysenko.banking.transaction.enums.TransactionType;

import java.math.BigDecimal;
import java.util.UUID;

@DiscriminatorColumn(name = "transaction_type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@SuperBuilder
@Entity
@Audited
@AuditOverride(forClass = BaseEntity.class)
public class Transaction extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "transaction_uuid ", nullable = false, unique = true)
    private UUID transactionUUID;

    protected BigDecimal amount;

    protected boolean isSuspicious;

    protected Long cardId;

    protected boolean isSuccessful;

    public Transaction() {

    }

    public TransactionType type() {
        return TransactionType.TRANSACTION;
    }

}
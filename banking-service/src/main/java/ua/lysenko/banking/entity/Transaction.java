package ua.lysenko.banking.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ua.lysenko.banking.transaction.DTO.TransactionDTO;

import java.math.BigDecimal;
import java.util.UUID;

@DiscriminatorColumn(name = "transaction_type", discriminatorType = DiscriminatorType.STRING)
@Entity
@Getter
@Setter
@SuperBuilder
//@Audited
//@AuditOverride(forClass = Auditable.class)
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

}
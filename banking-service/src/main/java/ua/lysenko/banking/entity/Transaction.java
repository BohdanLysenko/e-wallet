package ua.lysenko.banking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@DiscriminatorColumn(name = "transaction_type", discriminatorType = DiscriminatorType.STRING)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Audited
//@AuditOverride(forClass = Auditable.class)
public class Transaction extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected BigDecimal amount;
    protected boolean isSuspicious;

    protected Long cardId;

    protected boolean isSuccessful;

}
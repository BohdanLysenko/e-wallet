package ua.lysenko.banking.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

@DiscriminatorValue("DEPOSIT")
@Entity
@Getter
@Setter
@SuperBuilder
@Audited
@AuditOverride(forClass = BaseEntity.class)
public class DepositTransaction extends Transaction {
    public DepositTransaction() {
    }
}

package ua.lysenko.banking.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

@DiscriminatorValue("WITHDRAWAL")
@Entity
@Getter
@Setter
@SuperBuilder
@Audited
@AuditOverride(forClass = BaseEntity.class)
public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction() {

    }

}

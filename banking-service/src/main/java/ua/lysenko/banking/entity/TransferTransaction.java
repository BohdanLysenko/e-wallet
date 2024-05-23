package ua.lysenko.banking.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

@DiscriminatorValue("TRANSFER")
@Entity
@SuperBuilder
@Getter
@Setter
@Audited
@AuditOverride(forClass = BaseEntity.class)
public class TransferTransaction extends Transaction {

    private Long destinationCardId;

    public TransferTransaction() {

    }
}

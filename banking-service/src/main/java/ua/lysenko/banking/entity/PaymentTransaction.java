package ua.lysenko.banking.entity;

import jakarta.persistence.DiscriminatorValue;
    import jakarta.persistence.Entity;
    import lombok.Getter;
    import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

@DiscriminatorValue("PAYMENT")
@Entity
@Getter
@Setter
@Audited
@SuperBuilder
@AuditOverride(forClass = BaseEntity.class)
public class PaymentTransaction extends Transaction {

    private Long merchantId;

    public PaymentTransaction() {

    }
}

package ua.lysenko.banking.entity;

import jakarta.persistence.DiscriminatorValue;
    import jakarta.persistence.Entity;
    import lombok.Getter;
    import lombok.Setter;

@DiscriminatorValue("PAYMENT")
@Entity
@Getter
@Setter
public class PaymentTransaction extends Transaction {

    private Long merchantId;

}

package ua.lysenko.banking.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@DiscriminatorValue("Transfer")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transfer extends Transaction {

    private Long receiverCardId;

}

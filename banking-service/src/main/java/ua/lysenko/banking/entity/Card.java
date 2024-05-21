package ua.lysenko.banking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@SuperBuilder
//@Audited
//@AuditOverride(forClass = Auditable.class)
@Table(name = "cards")
public class Card extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal balance;
    private String cardNumber;
    private Date expirationDate;

    @ManyToOne
    private Wallet wallet;
    @Column(name = "active",nullable = false)
    private boolean active;

    private int cvv;

    public Card() {

    }
}

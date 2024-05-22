package ua.lysenko.banking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import java.math.BigDecimal;
import java.util.Date;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;

@Entity
@Getter
@Setter
@SuperBuilder
@Audited
@AuditOverride(forClass = BaseEntity.class)
public class Card extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal balance;
    private String cardNumber;
    private Date expirationDate;

    @ManyToOne
    @Audited(targetAuditMode = NOT_AUDITED)
    private Wallet wallet;
    @Column(name = "active",nullable = false)
    private boolean active;

    private int cvv;

    public Card() {

    }
}

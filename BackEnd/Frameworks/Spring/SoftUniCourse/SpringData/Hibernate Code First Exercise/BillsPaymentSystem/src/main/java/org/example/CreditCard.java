package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Month;
import java.time.Year;

@Entity
@Table(name = "credit_cards")
@Getter
@Setter
@NoArgsConstructor
public class CreditCard extends BillingDetails {
    @Column
    private String cardType;

    @Column(name = "expiration_month")
    private Month expirationMonth;

    @Column(name = "expiration_year")
    private Year expirationYear;
}

package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bank_accounts")
@Getter
@Setter
@NoArgsConstructor
public class BankAccount extends BillingDetails {
    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "switf_code")
    private String swiftCode;
}

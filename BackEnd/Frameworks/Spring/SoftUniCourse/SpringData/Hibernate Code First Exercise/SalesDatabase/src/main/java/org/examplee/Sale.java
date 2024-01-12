package org.examplee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class Sale {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private StoreLocation storeLocation;
    @Column
    private LocalDate date;
}

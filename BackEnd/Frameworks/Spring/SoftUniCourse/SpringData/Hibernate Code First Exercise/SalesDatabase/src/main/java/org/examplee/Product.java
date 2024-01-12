package org.examplee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private Double quantity;
    @Column
    private BigDecimal price;
    @OneToMany
    private Set<Sale> sales;
}

package org.examplee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class StoreLocation {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String locationName;
    @OneToMany
    private Set<Sale> sales;
}

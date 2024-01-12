package org.example;

import lombok.*;
import javax.persistence.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "wizard")
@NoArgsConstructor
public class Wizard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "first_name",length = 50)
    private String firstName;
    @Column(name = "last_name", length = 60,
    nullable = false)
    private String lastName;
    @Column(length = 1000)
    private String notes;
    @Column
    private int age;
    @OneToOne
    private Wand wand;
    @OneToMany
    @JoinTable(
            name="wizard_deposit",
            joinColumns=
            @JoinColumn(name="wizard_id", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="deposit_id", referencedColumnName="id")
    )
    private List<Deposit> depositList;
}

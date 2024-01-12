package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "countries")
@Getter
@Setter
@NoArgsConstructor
public class Countries{
    @Id
    @Column(length = 3)
    private String id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "countries")
    private Set<Continents> continent;
}

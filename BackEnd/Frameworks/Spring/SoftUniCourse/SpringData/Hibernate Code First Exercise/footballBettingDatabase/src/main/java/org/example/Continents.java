package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "continents")
@Getter
@Setter
@NoArgsConstructor
public class Continents extends IdExtender{
    @Column
    private String name;

    @ManyToMany
    @JoinTable
            (name = "countries_continents",
            joinColumns = @JoinColumn(name = "continent_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "country_id" , referencedColumnName = "id")
            )
    private Set<Countries> countries;

}

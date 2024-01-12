package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "towns")
@Getter
@Setter
@NoArgsConstructor
public class Town extends IdExtender{
    @Column
    private String name;

    @OneToOne
    @JoinColumn(name = "country_id")
    private Countries country;
}

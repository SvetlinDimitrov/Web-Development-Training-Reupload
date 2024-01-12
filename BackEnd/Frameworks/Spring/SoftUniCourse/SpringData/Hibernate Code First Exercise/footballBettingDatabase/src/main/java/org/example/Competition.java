package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "competitions")
@Getter
@Setter
@NoArgsConstructor
public class Competition extends IdExtender{
    @Column
    private String name;

    @OneToOne
    @JoinColumn(name = "competition_type_Id")
    private ConpetitionType conpetitionType;
}

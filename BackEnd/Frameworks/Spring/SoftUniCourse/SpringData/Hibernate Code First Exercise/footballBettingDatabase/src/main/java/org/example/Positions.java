package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "positions")
@Getter
@Setter
@NoArgsConstructor
public class Positions{
    @Id
    @Column(length = 2)
    private String id;

    @Column(name = "position_description")
    private String positionDescription;
}

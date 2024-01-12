package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rounds")
@Getter
@Setter
@NoArgsConstructor
public class Round extends IdExtender{
    @Column
    private String name;
}

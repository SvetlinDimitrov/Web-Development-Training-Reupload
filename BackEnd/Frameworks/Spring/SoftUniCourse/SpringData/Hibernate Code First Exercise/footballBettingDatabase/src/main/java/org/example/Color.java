package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "colors")
@Getter
@Setter
@NoArgsConstructor
public class Color extends IdExtender{
    @Column
    private String name;
}

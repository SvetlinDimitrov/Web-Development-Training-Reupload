package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "conpetition_types")
@Getter
@Setter
@NoArgsConstructor
public class ConpetitionType extends IdExtender{
    @Column
    private String type;
}

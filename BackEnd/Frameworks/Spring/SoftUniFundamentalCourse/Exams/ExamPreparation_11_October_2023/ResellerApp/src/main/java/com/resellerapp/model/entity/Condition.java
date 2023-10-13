package com.resellerapp.model.entity;

import com.resellerapp.model.enums.ConditionConstants;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "conditions")
public class Condition{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private ConditionConstants name;

    @Column(nullable = false)
    private String description;

}

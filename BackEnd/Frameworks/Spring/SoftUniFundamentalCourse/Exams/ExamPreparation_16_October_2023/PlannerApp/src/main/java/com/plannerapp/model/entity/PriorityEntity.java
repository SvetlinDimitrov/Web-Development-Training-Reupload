package com.plannerapp.model.entity;

import com.plannerapp.model.enums.PriorityConst;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class PriorityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PriorityConst name;

    @Column(nullable = false)
    private String description;

    @OneToMany
    private List<TaskEntity> tasks;


}

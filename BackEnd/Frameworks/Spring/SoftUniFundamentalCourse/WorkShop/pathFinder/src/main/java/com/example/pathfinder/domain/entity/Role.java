package com.example.pathfinder.domain.entity;

import com.example.pathfinder.domain.constants.BaseEntity;
import com.example.pathfinder.domain.constants.RoleConstant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(250)" , name = "name")
    private RoleConstant role;
}

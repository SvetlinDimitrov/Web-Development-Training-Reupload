package com.example.pathfinder.entity;

import com.example.pathfinder.constants.BaseEntity;
import com.example.pathfinder.constants.RoleConstant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
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
    @Enumerated
    @Column(columnDefinition = "varchar(250)")
    private RoleConstant role;
}

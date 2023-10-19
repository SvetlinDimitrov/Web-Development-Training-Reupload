package com.plannerapp.model.entity;

import com.plannerapp.model.enums.PriorityEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true , nullable = false)
    private PriorityEnum name;
    @Column(nullable = false)
    private String description;

    public Priority(PriorityEnum name) {
        switch (name) {
            case LOW:
                description = "Should be fixed if time permits but can be postponed.";
                break;
            case IMPORTANT:
                description = "A core functionality that your product is explicitly supposed to perform is compromised.";
                break;
            default:
                description = "An urgent problem that blocks the system use until the issue is resolved.";
        }
        this.name = name;
    }
}

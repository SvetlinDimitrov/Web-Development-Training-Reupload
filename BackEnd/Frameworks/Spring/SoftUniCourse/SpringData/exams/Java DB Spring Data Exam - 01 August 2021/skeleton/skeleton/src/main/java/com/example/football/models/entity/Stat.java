package com.example.football.models.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "stats")
public class Stat extends BaseEntity {

    //    • shooting – a floating point number. The value must be positive (larger than 0).
    //    • passing – a floating point number. The value must be positive (larger than 0).
    //    • endurance – a floating point number. The value must be positive (larger than 0).

    @Column(nullable = false,
            columnDefinition = "float")
    private Double shooting;

    @Column(nullable = false,
            columnDefinition = "float")
    private Double passing;

    @Column(nullable = false,
            columnDefinition = "float")
    private Double endurance;

    @OneToMany(mappedBy = "stat")
    private List<Player> playerList;

}

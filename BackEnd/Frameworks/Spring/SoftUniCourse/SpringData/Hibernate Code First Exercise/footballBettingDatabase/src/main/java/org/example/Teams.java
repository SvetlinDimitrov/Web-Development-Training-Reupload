package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "teams")
@Getter
@Setter
@NoArgsConstructor
public class Teams extends IdExtender{
    @Column
    private String name;

    @Column
    private String logo;

    @Column(length = 3)
    private String initials;

    @OneToOne
    @JoinColumn(name = "primary_kit_color")
    private Color primaryKitColor;

    @OneToOne
    @JoinColumn(name = "secondary_kit_color")
    private Color secodoryKitColor;

    @OneToOne
    @JoinColumn(name = "town_id")
    private Town town;

    @Column
    private Double budget;
}

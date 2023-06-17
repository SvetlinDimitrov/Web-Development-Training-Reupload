package com.example.battleships.domain.bindingViews;

import com.example.battleships.domain.constants.CategoryConstants;
import com.example.battleships.domain.entity.Ship;
import com.example.battleships.exeptions.shipConstraint.ShipConstraintName;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewShip implements Serializable {

    @Size(min = 2 , max = 10)
    @NotEmpty
    @ShipConstraintName
    private String name;

    @Positive
    @NotNull
    private Long health;


    @NotNull
    private Long power;

    @Past
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    @NotNull
    private CategoryConstants category;

    public Ship toShip() {
        return Ship.builder()
                .name(name)
                .health(health)
                .power(power)
                .created(created)
                .build();
    }
}

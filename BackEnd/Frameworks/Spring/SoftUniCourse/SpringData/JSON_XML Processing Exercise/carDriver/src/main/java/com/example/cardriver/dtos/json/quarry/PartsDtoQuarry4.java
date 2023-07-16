package com.example.cardriver.dtos.json.quarry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class PartsDtoQuarry4 {
    private String Name;
    private BigDecimal Price;

    public PartsDtoQuarry4(String name, BigDecimal price) {
        Name = name;
        Price = price;
    }
}

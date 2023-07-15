package com.example.cardriver.dtos.initdtos;

import com.example.cardriver.entity.Part;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PartDto {
    private String name ;
    private BigDecimal price;
    private Integer quantity;
    public Part toPart(){
        return Part.builder()
                .name(name)
                .price(price)
                .quantity(quantity)
                .build();
    }
}

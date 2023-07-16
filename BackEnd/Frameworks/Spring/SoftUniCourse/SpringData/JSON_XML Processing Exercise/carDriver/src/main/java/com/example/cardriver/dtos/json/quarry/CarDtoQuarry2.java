package com.example.cardriver.dtos.json.quarry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Setter
@Getter
@NoArgsConstructor
public class CarDtoQuarry2 {
    private Integer id;
    private String make;
    private String model;
    private BigInteger travelledDistance;

    public CarDtoQuarry2(Integer id, String make, String model, BigInteger travelledDistance) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
    }
}

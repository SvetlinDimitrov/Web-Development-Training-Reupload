package com.example.cardriver.dtos.quarry6;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Setter
@Getter
@NoArgsConstructor
public class CarDtoQuarry6 {

    private String Make;
    private String Model;
    private BigInteger TravelledDistance;

    public CarDtoQuarry6(String make, String model, BigInteger travelledDistance) {
        Make = make;
        Model = model;
        TravelledDistance = travelledDistance;
    }
}

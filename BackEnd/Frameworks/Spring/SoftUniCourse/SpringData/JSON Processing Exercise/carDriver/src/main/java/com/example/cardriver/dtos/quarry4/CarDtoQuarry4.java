package com.example.cardriver.dtos.quarry4;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CarDtoQuarry4 {
    private String Make;
    private String Model;
    private BigInteger TravelledDistance;
    private List<PartsDtoQuarry4> parts = new ArrayList<>();

    public CarDtoQuarry4(String make, String model, BigInteger travelledDistance) {
        Make = make;
        Model = model;
        TravelledDistance = travelledDistance;
    }
}

package com.example.cardriver.dtos.json.initDtos;

import com.example.cardriver.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private String model;
    private String make;
    private BigInteger travelledDistance;

    public Car toCar(){
        return Car.builder()
                .model(model)
                .make(make)
                .travelledDistance(travelledDistance)
                .build();
    }
}

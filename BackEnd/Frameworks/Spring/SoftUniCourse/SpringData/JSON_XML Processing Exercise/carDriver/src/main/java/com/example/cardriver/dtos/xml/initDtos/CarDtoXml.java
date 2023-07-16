package com.example.cardriver.dtos.xml.initDtos;

import com.example.cardriver.entity.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
@NoArgsConstructor
public class CarDtoXml {
    @XmlElement(name = "make")
    private String make;
    @XmlElement(name = "model")
    private String model;
    @XmlElement(name = "travelled-distance")
    private BigInteger travelled;

    public Car toCar(){
        return Car.builder()
                .make(make)
                .model(model)
                .travelledDistance(travelled)
                .build();
    }
}

package com.example.cardriver.dtos.xml.quarry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
@NoArgsConstructor
public class CarDtoQuarry6Xml {
    @XmlAttribute(name = "make")
    private String Make;
    @XmlAttribute(name = "model")
    private String Model;
    @XmlAttribute(name = "travelled-distance")
    private BigInteger TravelledDistance;

    public CarDtoQuarry6Xml(String make, String model, BigInteger travelledDistance) {
        Make = make;
        Model = model;
        TravelledDistance = travelledDistance;
    }
}

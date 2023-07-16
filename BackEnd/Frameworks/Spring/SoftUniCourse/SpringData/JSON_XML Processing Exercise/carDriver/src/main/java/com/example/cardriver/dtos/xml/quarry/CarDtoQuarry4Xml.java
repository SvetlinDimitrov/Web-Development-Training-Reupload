package com.example.cardriver.dtos.xml.quarry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
@NoArgsConstructor
public class CarDtoQuarry4Xml {

    @XmlAttribute(name = "make")
    private String make;
    @XmlAttribute(name = "model")
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private BigInteger travelledDistance;

    @XmlElementWrapper(name = "parts")
    private List<PartDtoQuarry4Xml> parts;

    public CarDtoQuarry4Xml(String make, String model, BigInteger travelledDistance) {
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
    }
}

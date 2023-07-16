package com.example.cardriver.dtos.xml.quarry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
@NoArgsConstructor
public class CarDtoQuarry2Xml {
        @XmlAttribute(name = "id")
        private Integer id;
        @XmlAttribute(name = "make")
        private String make;
        @XmlAttribute(name = "model")
        private String model;
        @XmlAttribute(name = "travelled-distance")
        private BigInteger travelledDistance;

        public CarDtoQuarry2Xml(Integer id, String make, String model, BigInteger travelledDistance) {
                this.id = id;
                this.make = make;
                this.model = model;
                this.travelledDistance = travelledDistance;
        }
}

package com.example.cardriver.dtos.xml.quarry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
@NoArgsConstructor
public class CarDtoWrapperQuarry2Xml {
    @XmlElement(name = "car")
    private List<CarDtoQuarry2Xml> customers;

    public CarDtoWrapperQuarry2Xml(List<CarDtoQuarry2Xml> customers) {
        this.customers = customers;
    }
}

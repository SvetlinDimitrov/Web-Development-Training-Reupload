package com.example.cardriver.dtos.xml.quarry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
@NoArgsConstructor
public class CustomerDtoQuarry5Xml implements Comparable<CustomerDtoQuarry5Xml>{
    @XmlAttribute(name = "full-name")
    private String fullName;
    @XmlAttribute(name = "bought-cars")
    private Integer boughtCars;
    @XmlAttribute(name = "spent-money")
    private BigDecimal spentMoney;

    public CustomerDtoQuarry5Xml(String fullName, Integer boughtCars, BigDecimal spentMoney) {
        this.fullName = fullName;
        this.boughtCars = boughtCars;
        this.spentMoney = spentMoney;
    }


    @Override
    public int compareTo(CustomerDtoQuarry5Xml o) {
        if(spentMoney.compareTo(o.spentMoney) > 0){
            return -1;
        }

        if(boughtCars.compareTo(o.boughtCars) > 0){
            return -1;
        }

        return 1;
    }
}

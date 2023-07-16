package com.example.cardriver.dtos.xml.quarry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
@NoArgsConstructor
public class CustomerDtoQuarry5WrapperXml {
    @XmlElement(name = "customer")
    private List<CustomerDtoQuarry5Xml> customers;

    public CustomerDtoQuarry5WrapperXml(List<CustomerDtoQuarry5Xml> customers) {
        this.customers = customers;
    }
}

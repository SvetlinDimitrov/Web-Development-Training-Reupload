package com.example.cardriver.dtos.xml.quarry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
@NoArgsConstructor
public class SaleDtoQuarry6WrapperXml {
    @XmlElement(name = "sale")
    private List<SaleDtoQuarry6Xml> customers;

    public SaleDtoQuarry6WrapperXml(List<SaleDtoQuarry6Xml> customers) {
        this.customers = customers;
    }
}

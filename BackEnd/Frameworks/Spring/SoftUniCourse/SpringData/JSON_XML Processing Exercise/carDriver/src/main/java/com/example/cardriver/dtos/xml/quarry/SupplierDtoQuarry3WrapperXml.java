package com.example.cardriver.dtos.xml.quarry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
@NoArgsConstructor
public class SupplierDtoQuarry3WrapperXml {
    @XmlElement(name = "supplier")
    private List<SupplierDtoQuarry3Xml> suppliers;

    public SupplierDtoQuarry3WrapperXml(List<SupplierDtoQuarry3Xml> suppliers) {
        this.suppliers = suppliers;
    }
}

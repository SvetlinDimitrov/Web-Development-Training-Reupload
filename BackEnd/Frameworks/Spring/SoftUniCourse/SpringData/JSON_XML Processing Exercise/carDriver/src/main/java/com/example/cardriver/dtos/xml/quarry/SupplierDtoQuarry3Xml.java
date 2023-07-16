package com.example.cardriver.dtos.xml.quarry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
@NoArgsConstructor
public class SupplierDtoQuarry3Xml {
    @XmlAttribute(name = "id")
    private Integer id;
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "parts-count")
    private Integer partsCount;

    public SupplierDtoQuarry3Xml(Integer id, String name, Integer partsCount) {
        this.id = id;
        this.name = name;
        this.partsCount = partsCount;
    }
}

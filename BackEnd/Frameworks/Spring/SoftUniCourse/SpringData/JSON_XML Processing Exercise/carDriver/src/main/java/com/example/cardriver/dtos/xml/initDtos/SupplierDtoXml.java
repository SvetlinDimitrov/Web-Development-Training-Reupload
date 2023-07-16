package com.example.cardriver.dtos.xml.initDtos;

import com.example.cardriver.entity.Supplier;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
public class SupplierDtoXml {
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "is-importer")
    private Boolean isImporter;

    public Supplier toSupplier(){
        return Supplier.builder()
                .name(name)
                .isImporter(isImporter)
                .build();
    }
}

package com.example.cardriver.dtos.xml.initDtos;

import com.example.cardriver.entity.Part;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
@NoArgsConstructor
public class PartDtoXml {

    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "price")
    private BigDecimal price;
    @XmlAttribute(name = "quantity")
    private Integer quantity;

    public Part toPart (){
        return Part.builder()
                .name(name)
                .price(price)
                .quantity(quantity)
                .build();
    }

}

package com.example.productsshop.entities.Dtos.XML.product;


import javax.xml.bind.annotation.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "product")
public class ProductDtoImport {

    @XmlElement
    private String name;

    @XmlElement
    private BigDecimal price;
}

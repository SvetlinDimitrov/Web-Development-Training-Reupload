package com.example.productsshop.entities.Dtos.XML.product;

import javax.xml.bind.annotation.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "products")
public class ProductDtoImportWrapper {

    @XmlElement(name = "product")
    private List<ProductDtoImport> products;
}

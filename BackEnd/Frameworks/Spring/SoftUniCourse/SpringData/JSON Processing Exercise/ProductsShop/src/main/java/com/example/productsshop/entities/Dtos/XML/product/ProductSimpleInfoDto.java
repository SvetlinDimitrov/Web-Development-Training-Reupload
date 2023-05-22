package com.example.productsshop.entities.Dtos.XML.product;

import com.example.productsshop.entities.products.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "product")
public class ProductSimpleInfoDto {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private BigDecimal price;

    public static ProductSimpleInfoDto toProductSimpleInfoDto(Product product){
        return  new ProductSimpleInfoDto(product.getName() , product.getPrice());
    }

}

package com.example.productsshop.entities.Dtos.XML.user;

import com.example.productsshop.entities.products.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "product")
public class ProductSoldDtoXml {

    @XmlElement
    private String name;

    @XmlElement
    private BigDecimal price;

    @XmlElement(name = "buyer-first-name")
    private String buyerFirstName;

    @XmlElement(name = "buyer-last-name")
    private String buyerLastName;

    public static ProductSoldDtoXml toProductSoldDtoXml (Product product){
       return new ProductSoldDtoXml(product.getName() , product.getPrice(),
               product.getBuyer().getFirstName() , product.getBuyer().getLastName());
    }
}

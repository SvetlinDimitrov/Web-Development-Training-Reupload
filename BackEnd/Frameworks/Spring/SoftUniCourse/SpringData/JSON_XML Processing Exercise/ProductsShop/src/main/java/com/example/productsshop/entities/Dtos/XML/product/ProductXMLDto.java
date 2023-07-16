package com.example.productsshop.entities.Dtos.XML.product;

import com.example.productsshop.entities.products.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "product")

public class ProductXMLDto {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private BigDecimal price;

    @XmlAttribute(name = "seller")
    private String sellerName;

    public static ProductXMLDto toProductXMLDto (Product p){
        ProductXMLDto productXMLDto = new ProductXMLDto();
        productXMLDto.setName(p.getName());
        productXMLDto.setPrice(p.getPrice());
        productXMLDto.setSellerName(p.getSeller().getFirstName() + " " + p.getSeller().getLastName());
        return productXMLDto;
    }

}

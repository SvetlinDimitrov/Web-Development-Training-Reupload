package com.example.productsshop.entities.Dtos.XML.product;

import com.example.productsshop.entities.products.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "sold-products")
public class ProductSimpleInfoDtoWrapper {

    @XmlAttribute
    private Long count;

    @XmlElement(name = "product")
    private List<ProductSimpleInfoDto> products;

    public static ProductSimpleInfoDtoWrapper toWrapper(List<Product> products){
        return new ProductSimpleInfoDtoWrapper((long) products.size(),
                products.stream().map(ProductSimpleInfoDto::toProductSimpleInfoDto).toList());
    }
}

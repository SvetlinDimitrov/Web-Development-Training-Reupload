package com.example.productsshop.entities.Dtos.XML.categories;


import com.example.productsshop.entities.Dtos.Json.CategorySummary;
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
@XmlRootElement(name = "category")
public class CategorySummaryDto {

    @XmlAttribute
    private String name;

    @XmlElement(name = "products-count")
    private Long productsCount;

    @XmlElement(name = "average-price")
    private BigDecimal averagePrice;

    @XmlElement(name = "total-revenue")
    private BigDecimal totalRevenue;

    public static CategorySummaryDto toCategorySummaryDto(CategorySummary categorySummary){
        return new CategorySummaryDto(categorySummary.getCategory() ,
                categorySummary.getProductsCount(),
                BigDecimal.valueOf(categorySummary.getAveragePrice()),
                categorySummary.getTotalRevenue());
    }
}

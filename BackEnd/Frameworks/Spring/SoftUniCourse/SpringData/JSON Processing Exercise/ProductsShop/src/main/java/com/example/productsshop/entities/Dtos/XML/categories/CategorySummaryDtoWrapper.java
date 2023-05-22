package com.example.productsshop.entities.Dtos.XML.categories;

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
@XmlRootElement(name = "categories")
public class CategorySummaryDtoWrapper {

    @XmlElement(name = "category")
    private List<CategorySummaryDto> products;
}

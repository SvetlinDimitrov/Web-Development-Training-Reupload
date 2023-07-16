package com.example.cardriver.dtos.xml.quarry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
@NoArgsConstructor
public class SaleDtoQuarry6Xml {
    @XmlElement(name = "car")
    private CarDtoQuarry6Xml car;
    @XmlElement(name = "customer-name")
    private String customerName;
    @XmlElement(name = "discount")
    private Double Discount;
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;

    public SaleDtoQuarry6Xml(String customerName, Double Discount, BigDecimal price, BigDecimal priceWithDiscount) {
        this.customerName = customerName;
        this.Discount = Discount;
        this.price = price;
        this.priceWithDiscount = priceWithDiscount;
    }
}

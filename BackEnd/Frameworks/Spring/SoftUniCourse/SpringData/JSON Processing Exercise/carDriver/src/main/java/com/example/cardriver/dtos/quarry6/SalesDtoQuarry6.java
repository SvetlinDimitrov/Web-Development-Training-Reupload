package com.example.cardriver.dtos.quarry6;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class SalesDtoQuarry6 {
    private CarDtoQuarry6 car;
    private String customerName;
    private Double Discount;
    private BigDecimal price;
    private BigDecimal priceWithDiscount;

    public SalesDtoQuarry6(String customerName, Double Discount, BigDecimal price, BigDecimal priceWithDiscount) {
        this.customerName = customerName;
        this.Discount = Discount;
        this.price = price;
        this.priceWithDiscount = priceWithDiscount;
    }
}

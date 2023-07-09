package org.example;

import java.math.BigDecimal;

public class AmericanStyle extends Style{
    protected AmericanStyle(Product product) {
        super(product);
    }

    @Override
    public void sell() {
        System.out.println(getProduct().price.subtract(new BigDecimal("0.90")));
    }

    @Override
    public void buy() {
        System.out.println(getProduct().price.subtract(new BigDecimal("0.10")));
    }
}

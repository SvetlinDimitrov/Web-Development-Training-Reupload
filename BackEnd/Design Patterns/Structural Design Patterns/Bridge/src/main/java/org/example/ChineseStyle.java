package org.example;

import java.math.BigDecimal;

public class ChineseStyle extends Style {
    protected ChineseStyle(Product product) {
        super(product);
    }

    @Override
    public void sell() {
        System.out.println(getProduct().price.subtract(new BigDecimal("1.20")));
    }

    @Override
    public void buy() {
        System.out.println(getProduct().price.subtract(new BigDecimal("0.20")));
    }
}

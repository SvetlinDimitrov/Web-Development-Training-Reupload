package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Product {
    protected BigDecimal price;
    protected LocalDate consumable;

    protected Product(BigDecimal price, LocalDate consumable) {
        this.price = price;
        this.consumable = consumable;
    }
}

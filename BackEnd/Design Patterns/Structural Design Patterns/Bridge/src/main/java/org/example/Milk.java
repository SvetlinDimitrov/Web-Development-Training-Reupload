package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Milk extends Product{

    protected Milk(BigDecimal price, LocalDate consumable) {
        super(price, consumable);
    }
}

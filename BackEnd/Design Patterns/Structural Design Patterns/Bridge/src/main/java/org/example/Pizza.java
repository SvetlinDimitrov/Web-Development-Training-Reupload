package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pizza extends Product{
    protected Pizza(BigDecimal price, LocalDate consumable) {
        super(price, consumable);
    }
}

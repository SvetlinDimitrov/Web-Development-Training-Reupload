package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Style style = new AmericanStyle(new Pizza(new BigDecimal(10) , LocalDate.now()));
        style.buy();
        style.sell();
    }
}
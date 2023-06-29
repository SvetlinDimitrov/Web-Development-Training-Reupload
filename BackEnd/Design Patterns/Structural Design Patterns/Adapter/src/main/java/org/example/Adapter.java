package org.example;

import java.math.BigDecimal;

public class Adapter implements AdvanceCalculator{
    private Calculator calculator;

    public Adapter(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public String insaneCalculate() {
        BigDecimal bigDecimal = new BigDecimal(calculator.calculate());
        return bigDecimal.multiply(bigDecimal).toString();
    }
}

package org.example;

import java.math.BigDecimal;

public class MultiplyCalc implements Calculator{

    private String v;
    private String v1;

    public MultiplyCalc(String v, String v1) {
        this.v = v;
        this.v1 = v1;
    }

    @Override
    public  String calculate() {
        BigDecimal bigDecimal = new BigDecimal(v);
        BigDecimal bigDecimal1 = new BigDecimal(v1);
        return bigDecimal1.multiply(bigDecimal).toString();
    }
}

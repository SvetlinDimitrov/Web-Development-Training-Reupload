package com.example.cardriver.dtos.json.quarry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDtoQuarry5 implements Comparable<CustomerDtoQuarry5>{
    private String fullName;
    private Integer boughtCars;
    private BigDecimal spentMoney;

    public CustomerDtoQuarry5(String fullName, Integer boughtCars, BigDecimal spentMoney) {
        this.fullName = fullName;
        this.boughtCars = boughtCars;
        this.spentMoney = spentMoney;
    }

    @Override
    public int compareTo(CustomerDtoQuarry5 o) {
        if(spentMoney.compareTo(o.spentMoney) > 0){
            return -1;
        }

        if(boughtCars.compareTo(o.boughtCars) > 0){
            return -1;
        }

        return 1;
    }
}

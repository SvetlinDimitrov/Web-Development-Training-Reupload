package com.example.cardriver.dtos.json.initDtos;
import com.example.cardriver.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private String name;
    private Boolean isYoungDriver;
    public Customer toCustomer(){
        return Customer.builder()
                .name(name)
                .birthDate(LocalDate.now())
                .isYoungDriver(isYoungDriver)
                .build();
    }
}

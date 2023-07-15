package com.example.cardriver.dtos.initdtos;
import com.example.cardriver.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

package com.example.cardriver.dtos.xml.initDtos;

import com.example.cardriver.entity.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
@NoArgsConstructor
public class CustomerDtoXml {
    @XmlAttribute(name = "name")
    private String name;

    @XmlElement(name = "is-young-driver")
    private Boolean isYoungDriver;

    public Customer toCustomer(){
        return Customer.builder()
                .name(name)
                .birthDate(LocalDate.now())
                .isYoungDriver(isYoungDriver)
                .build();
    }

}

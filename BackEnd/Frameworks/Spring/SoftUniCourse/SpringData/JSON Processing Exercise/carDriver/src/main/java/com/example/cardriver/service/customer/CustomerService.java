package com.example.cardriver.service.customer;

import com.example.cardriver.dtos.quarry5.CustomerDtoQuarry5;
import com.example.cardriver.entity.Customer;

import java.util.List;

public interface CustomerService {
    boolean isEmpty();

    void saveCustomer(Customer c);

    Customer getRandomCustomer();

    List<CustomerDtoQuarry5> getTotalSalesByCustomer();
}

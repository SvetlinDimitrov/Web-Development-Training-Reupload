package com.example.cardriver.service.customer;

import com.example.cardriver.dtos.quarry5.CustomerDtoQuarry5;
import com.example.cardriver.entity.Customer;
import com.example.cardriver.entity.Part;
import com.example.cardriver.repos.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean isEmpty() {
        return customerRepository.count() == 0;
    }

    @Override
    public void saveCustomer(Customer c) {
        customerRepository.save(c);
    }

    @Override
    public Customer getRandomCustomer() {
        Random random = new Random();
        int n = random.nextInt((int) customerRepository.count());
        return customerRepository.getReferenceById(++n);
    }

    @Override
    @Transactional
    public List<CustomerDtoQuarry5> getTotalSalesByCustomer() {
        return customerRepository.findAllWithAtLeastOneCar()
                .stream()
                .filter(c -> !c.getSales().isEmpty())
                .map(c -> new CustomerDtoQuarry5(
                        c.getName(),
                        c.getSales().size(),
                        (c.getSales()
                                .stream()
                                .map(s -> s.getCar().getParts())
                                .flatMap(Collection::stream)
                                .map(Part::getPrice)
                                .reduce(new BigDecimal(0), BigDecimal::add))))
                .sorted()
                .toList();
    }
}

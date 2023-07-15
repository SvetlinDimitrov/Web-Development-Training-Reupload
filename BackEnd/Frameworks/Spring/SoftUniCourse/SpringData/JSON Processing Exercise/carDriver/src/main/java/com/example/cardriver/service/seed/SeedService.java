package com.example.cardriver.service.seed;

import com.example.cardriver.service.car.CarService;
import com.example.cardriver.service.customer.CustomerService;
import com.example.cardriver.service.part.PartService;
import com.example.cardriver.service.sale.SaleService;
import com.example.cardriver.service.supplier.SupplierService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;
import java.util.Random;

@Component
public abstract class SeedService {
    @Autowired
    protected CarService carService;
    @Autowired
    protected SupplierService supplierService;
    @Autowired
    protected PartService partService;
    @Autowired
    protected CustomerService customerService;
    @Autowired
    protected SaleService saleService;
    @Autowired
    protected Gson gson;

    protected abstract void seedCars();
    protected abstract void seedSuppliers();
    protected abstract void seedParts();
    protected abstract void seedCustomers();
    protected abstract void seedSales();

    public void seedAll(){
        if(supplierService.isEmpty()){
            seedSuppliers();
        }
        if(partService.isEmpty()){
            seedParts();
        }
        if(carService.isEmpty()){
            seedCars();
        }
        if(customerService.isEmpty()){
            seedCustomers();
        }
        if(saleService.isEmpty()){
            seedSales();
        }
    }

    protected Reader getReader(String url){
        InputStream inputStream = getClass().getResourceAsStream(url);
        return new BufferedReader(new InputStreamReader(inputStream));
    }
    protected Double getRandomDiscount(){
        Random random = new Random();
        List<Double> discount = List.of( 0.0, 0.05, 0.1, 0.15, 0.2, 0.3, 0.4 ,0.5);
        int n = random.nextInt(discount.size());
        return discount.get(n);
    }
}

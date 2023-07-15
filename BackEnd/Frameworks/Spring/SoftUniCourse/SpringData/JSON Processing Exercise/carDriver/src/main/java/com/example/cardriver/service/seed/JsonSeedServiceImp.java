package com.example.cardriver.service.seed;

import com.example.cardriver.dtos.initdtos.CarDto;
import com.example.cardriver.dtos.initdtos.CustomerDto;
import com.example.cardriver.dtos.initdtos.PartDto;
import com.example.cardriver.dtos.initdtos.SupplierDto;
import com.example.cardriver.entity.Sale;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class JsonSeedServiceImp extends SeedService{
    private static final String JSON_CARS_RES = "/09. DB-Advanced-JSON-Processing-Exercises-Resources/cars.json";
    private static final String JSON_SUPPLIERS_RES = "/09. DB-Advanced-JSON-Processing-Exercises-Resources/suppliers.json";
    private static final String JSON_PARTS_RES = "/09. DB-Advanced-JSON-Processing-Exercises-Resources/parts.json";
    private static final String JSON_CUSTOMERS_RES = "/09. DB-Advanced-JSON-Processing-Exercises-Resources/customers.json";

    @Override
    protected void seedSuppliers() {
        Arrays.stream(gson.fromJson(getReader(JSON_SUPPLIERS_RES), SupplierDto[].class))
                .map(SupplierDto::toSupplier)
                .forEach(c-> supplierService.saveSupplier(c));
    }
    @Override
    protected void seedParts() {
        Arrays.stream(gson.fromJson(getReader(JSON_PARTS_RES) , PartDto[].class))
                .map(PartDto::toPart)
                .forEach(p-> {
                    p.setSupplier(supplierService.getRandomSupplier());
                    partService.savePart(p);
                });
    }
    @Override
    protected void seedCars(){
        Arrays.stream(gson.fromJson(getReader(JSON_CARS_RES), CarDto[].class))
                .map(CarDto::toCar)
                .forEach(c->{
                    c.setParts(partService.getRandomParts());
                    carService.saveCar(c);
                });
    }
    @Override
    protected void seedCustomers() {
        Arrays.stream(gson.fromJson(getReader(JSON_CUSTOMERS_RES) , CustomerDto[].class))
                .map(CustomerDto::toCustomer)
                .forEach(c->customerService.saveCustomer(c));
    }
    @Override
    protected void seedSales() {
        for (int i = 0; i < 150; i++) {
            Sale sale = new Sale();
            sale.setCar(carService.getRandomCar());
            sale.setCustomer(customerService.getRandomCustomer());
            sale.setDiscount(getRandomDiscount());
            saleService.saveSale(sale);
        }
    }
}

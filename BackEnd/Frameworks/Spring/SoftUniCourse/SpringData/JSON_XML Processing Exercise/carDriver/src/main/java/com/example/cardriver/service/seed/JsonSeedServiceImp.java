package com.example.cardriver.service.seed;

import com.example.cardriver.dtos.json.initDtos.CarDto;
import com.example.cardriver.dtos.json.initDtos.CustomerDto;
import com.example.cardriver.dtos.json.initDtos.PartDto;
import com.example.cardriver.dtos.json.initDtos.SupplierDto;
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
}

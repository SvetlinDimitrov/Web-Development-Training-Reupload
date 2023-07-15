package com.example.cardriver;

import com.example.cardriver.service.car.CarService;
import com.example.cardriver.service.customer.CustomerService;
import com.example.cardriver.service.sale.SaleService;
import com.example.cardriver.service.seed.JsonSeedServiceImp;
import com.example.cardriver.service.seed.SeedService;
import com.example.cardriver.service.supplier.SupplierService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.List;

@Component
public abstract class Controller implements CommandLineRunner {
    //SeedService uses template Design pattern
    protected SeedService service;
    protected CarService carService;
    protected SupplierService supplierService;
    protected CustomerService customerService;
    protected SaleService saleService;
    protected Gson gson;

    public Controller(JsonSeedServiceImp service, CarService carService, SupplierService supplierService, CustomerService customerService, SaleService saleService, Gson gson) {
        this.service = service;
        this.carService = carService;
        this.supplierService = supplierService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws IOException {
        service.seedAll();

        orderedCustomers();
        carsFromMakeToyota();
        localSuppliers();
        carsWithTheirListOfParts();
        totalSalesByCustomer();
        salesWithAppliedDiscount();
    }

    protected abstract void orderedCustomers();
    protected abstract void carsFromMakeToyota() throws IOException;
    protected abstract void localSuppliers() throws IOException;
    protected abstract void carsWithTheirListOfParts() throws IOException;
    protected abstract void totalSalesByCustomer() throws IOException;
    protected abstract void salesWithAppliedDiscount() throws IOException;
    protected void getWriter(Path path, List<?> list) throws IOException {
        Writer writer = new FileWriter(new File(path.toUri()));
        gson.toJson(list, writer);
        writer.flush();
        writer.close();
    }

}

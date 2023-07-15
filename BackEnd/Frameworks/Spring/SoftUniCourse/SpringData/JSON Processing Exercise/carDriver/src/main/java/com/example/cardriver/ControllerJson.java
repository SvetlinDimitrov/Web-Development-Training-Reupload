package com.example.cardriver;

import com.example.cardriver.service.car.CarService;
import com.example.cardriver.service.customer.CustomerService;
import com.example.cardriver.service.sale.SaleService;
import com.example.cardriver.service.seed.JsonSeedServiceImp;
import com.example.cardriver.service.supplier.SupplierService;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;

import static com.example.cardriver.constants.Units.*;

@Component
public class ControllerJson extends Controller{
    public ControllerJson(JsonSeedServiceImp service, CarService carService, SupplierService supplierService, CustomerService customerService, SaleService saleService, Gson gson) {
        super(service, carService, supplierService, customerService, saleService, gson);
    }

    @Override
    protected void orderedCustomers() {
        //TODO:finish THIS
    }
    @Override
    public void carsFromMakeToyota() throws IOException {
        getWriter(Path.of(JSON_QUARRY2_ANSWER) , carService.getAllCarsByMake("Toyota"));
    }
    @Override
    public void localSuppliers() throws IOException {
        //Get all suppliers that do not import parts from abroad.
        //Did not that one  so i just took all suppliers
        getWriter(Path.of(JSON_QUARRY3_ANSWER), supplierService.getAllSuppliers());
    }
    @Override
    protected void carsWithTheirListOfParts() throws IOException {
        getWriter(Path.of(JSON_QUARRY4_ANSWER),carService.getAllCarsForQuarry4());
    }
    @Override
    protected void totalSalesByCustomer() throws IOException {
        getWriter(Path.of(JSON_QUARRY5_ANSWER) ,  customerService.getTotalSalesByCustomer());
    }
    @Override
    protected void salesWithAppliedDiscount() throws IOException {
        getWriter(Path.of(JSON_QUARRY6_ANSWER) , saleService.getAllSalesWithAppliedDiscount());
    }

}

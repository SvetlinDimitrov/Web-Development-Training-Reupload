package com.example.cardriver;

import com.example.cardriver.dtos.json.quarry.CarDtoQuarry2;
import com.example.cardriver.service.car.CarService;
import com.example.cardriver.service.customer.CustomerService;
import com.example.cardriver.service.sale.SaleService;
import com.example.cardriver.service.seed.JsonSeedServiceImp;
import com.example.cardriver.service.seed.XmlSeedServiceImp;
import com.example.cardriver.service.supplier.SupplierService;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.List;

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
        List<CarDtoQuarry2> toyota = carService.getAllCarsByMakeJson("Toyota");

        Writer writer = getWriter(Path.of(JSON_QUARRY2_ANSWER));
        gson.toJson(toyota , writer);
        writer.flush();
        writer.close();
    }

    @Override
    public void localSuppliers() throws IOException {
        //Get all suppliers that do not import parts from abroad.
        //Did not that one  so i just took all suppliers
        Writer writer = getWriter(Path.of(JSON_QUARRY3_ANSWER));
        gson.toJson(supplierService.getAllSuppliersJson());
        writer.flush();
        writer.close();
    }
    @Override
    protected void carsWithTheirListOfParts() throws IOException {
        Writer writer = getWriter(Path.of(JSON_QUARRY4_ANSWER));
        gson.toJson(carService.getAllCarsForQuarry4Json() , writer);
        writer.flush();
        writer.close();
    }
    @Override
    protected void totalSalesByCustomer() throws IOException {
        Writer writer = getWriter(Path.of(JSON_QUARRY5_ANSWER));
        gson.toJson(customerService.getTotalSalesByCustomerJson() , writer);
        writer.flush();
        writer.close();
    }
    @Override
    protected void salesWithAppliedDiscount() throws IOException {
        Writer writer = getWriter(Path.of(JSON_QUARRY6_ANSWER));
        gson.toJson(saleService.getAllSalesWithAppliedDiscountJson() , writer);
        writer.flush();
        writer.close();
    }

}

package com.example.cardriver;

import com.example.cardriver.service.car.CarService;
import com.example.cardriver.service.customer.CustomerService;
import com.example.cardriver.service.sale.SaleService;
import com.example.cardriver.service.seed.JsonSeedServiceImp;
import com.example.cardriver.service.seed.SeedService;
import com.example.cardriver.service.seed.XmlSeedServiceImp;
import com.example.cardriver.service.supplier.SupplierService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;

@Component
//Controller uses template design pattern
//when application starts ControllerJason and ControllerXml will start at the same time
public abstract class Controller implements CommandLineRunner {
    //SeedService uses template Design pattern
    //If you want to fill the data with json files use JsonSeedServiceImp in the constructor
    //If you want to fill the data with xml files use XmlSeedServiceImp in the constructor
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
    public void run(String... args) throws IOException, JAXBException {
        service.seedAll();

        orderedCustomers();
        carsFromMakeToyota();
        localSuppliers();
        carsWithTheirListOfParts();
        totalSalesByCustomer();
        salesWithAppliedDiscount();
    }

    protected abstract void orderedCustomers();
    protected abstract void carsFromMakeToyota() throws IOException, JAXBException;
    protected abstract void localSuppliers() throws IOException, JAXBException;
    protected abstract void carsWithTheirListOfParts() throws IOException, JAXBException;
    protected abstract void totalSalesByCustomer() throws IOException, JAXBException;
    protected abstract void salesWithAppliedDiscount() throws IOException, JAXBException;
    protected Writer getWriter(Path path) throws IOException {
       return new FileWriter(new File(path.toUri()));
    }
    protected<T> void XmlWrite(T t,JAXBContext context, String path) throws JAXBException, IOException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(t , getWriter(Path.of(path)));
    }


}

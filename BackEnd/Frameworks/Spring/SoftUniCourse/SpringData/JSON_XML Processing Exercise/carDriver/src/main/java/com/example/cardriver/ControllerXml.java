package com.example.cardriver;

import com.example.cardriver.dtos.xml.quarry.*;
import com.example.cardriver.service.car.CarService;
import com.example.cardriver.service.customer.CustomerService;
import com.example.cardriver.service.sale.SaleService;
import com.example.cardriver.service.seed.JsonSeedServiceImp;
import com.example.cardriver.service.seed.XmlSeedServiceImp;
import com.example.cardriver.service.supplier.SupplierService;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;

import static com.example.cardriver.constants.Units.*;

@Component
public class ControllerXml extends Controller {
    public ControllerXml(JsonSeedServiceImp service, CarService carService, SupplierService supplierService, CustomerService customerService, SaleService saleService, Gson gson) {
        super(service, carService, supplierService, customerService, saleService, gson);
    }

    @Override
    public void orderedCustomers() {
        //TODO:could not fix the date
    }

    @Override
    public void carsFromMakeToyota() throws JAXBException, IOException {
        CarDtoWrapperQuarry2Xml wrapperXml = new CarDtoWrapperQuarry2Xml(carService.getAllCarsByMakeXml("Toyota"));

        JAXBContext context = JAXBContext.newInstance(CarDtoWrapperQuarry2Xml.class);
        XmlWrite(wrapperXml , context ,XML_QUARRY2_ANSWER);
    }

    @Override
    public void localSuppliers() throws IOException, JAXBException {
        SupplierDtoQuarry3WrapperXml wrapperXml = new SupplierDtoQuarry3WrapperXml(supplierService.getAllSuppliersXml());

        JAXBContext context = JAXBContext.newInstance(SupplierDtoQuarry3WrapperXml.class);
        XmlWrite(wrapperXml , context ,XML_QUARRY3_ANSWER);
    }

    @Override
    public void carsWithTheirListOfParts() throws IOException, JAXBException {
        CarDtoQuarry4WrapperXml wrapperXml = new CarDtoQuarry4WrapperXml(carService.getAllCarsForQuarry4Xml());

        JAXBContext context = JAXBContext.newInstance(CarDtoQuarry4WrapperXml.class);
        XmlWrite(wrapperXml , context ,XML_QUARRY4_ANSWER);
    }

    @Override
    public void totalSalesByCustomer() throws IOException, JAXBException {
        CustomerDtoQuarry5WrapperXml wrapperXml = new CustomerDtoQuarry5WrapperXml(customerService.getTotalSalesByCustomerXml());

        JAXBContext context = JAXBContext.newInstance(CustomerDtoQuarry5WrapperXml.class);
        XmlWrite(wrapperXml , context ,XML_QUARRY5_ANSWER);
    }

    @Override
    public void salesWithAppliedDiscount() throws IOException, JAXBException {
        SaleDtoQuarry6WrapperXml wrapperXml = new SaleDtoQuarry6WrapperXml(saleService.getAllSalesWithAppliedDiscountXml());

        JAXBContext context = JAXBContext.newInstance(SaleDtoQuarry6WrapperXml.class);
        XmlWrite(wrapperXml , context ,XML_QUARRY6_ANSWER);


    }


}

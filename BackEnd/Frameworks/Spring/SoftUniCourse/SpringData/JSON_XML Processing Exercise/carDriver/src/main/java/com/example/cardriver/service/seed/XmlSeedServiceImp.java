package com.example.cardriver.service.seed;

import com.example.cardriver.dtos.xml.initDtos.*;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@Component
public class XmlSeedServiceImp extends SeedService{
    private static final String XML_CARS_RES = "/09. XML-Processing-Exercises/cars.xml";
    private static final String XML_SUPPLIERS_RES = "/09. XML-Processing-Exercises/suppliers.xml";
    private static final String XML_PARTS_RES = "/09. XML-Processing-Exercises/parts.xml";
    private static final String XML_CUSTOMERS_RES = "/09. XML-Processing-Exercises/customers.xml";
    @Override
    public void seedCars() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CarDtoWrapperXml.class);

        CarDtoWrapperXml unmarshal =(CarDtoWrapperXml) jaxbContext
                .createUnmarshaller()
                .unmarshal(getReader(XML_CARS_RES));

        unmarshal.getCars()
                .stream()
                .map(CarDtoXml::toCar)
                .forEach(c->{
                    c.setParts(partService.getRandomParts());
                    carService.saveCar(c);
                });
    }

    @Override
    public void seedSuppliers() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(SupplierDtoWrapperXml.class);
        SupplierDtoWrapperXml unmarshal =(SupplierDtoWrapperXml) jaxbContext.createUnmarshaller().unmarshal(getReader(XML_SUPPLIERS_RES));
        unmarshal
                .getSupplier()
                .stream()
                .map(SupplierDtoXml::toSupplier)
                .forEach(c-> supplierService.saveSupplier(c));
    }

    @Override
    public void seedParts() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PartDtoWrapperXml.class);

        PartDtoWrapperXml unmarshal =(PartDtoWrapperXml) jaxbContext
                .createUnmarshaller()
                .unmarshal(getReader(XML_PARTS_RES));

        unmarshal
                .getParts()
                .stream()
                .map(PartDtoXml::toPart)
                .forEach(p-> {
                    p.setSupplier(supplierService.getRandomSupplier());
                    partService.savePart(p);
                });
    }

    @Override
    public void seedCustomers() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CustomerDtoWrapperXml.class);

        CustomerDtoWrapperXml unmarshal =(CustomerDtoWrapperXml) jaxbContext
                .createUnmarshaller()
                .unmarshal(getReader(XML_CUSTOMERS_RES));

        unmarshal.getCustomers()
                .stream()
                .map(CustomerDtoXml::toCustomer)
                .forEach(c->customerService.saveCustomer(c));
    }

}
